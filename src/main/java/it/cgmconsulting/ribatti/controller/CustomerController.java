package it.cgmconsulting.ribatti.controller;

import it.cgmconsulting.ribatti.payload.response.FilmRentResponse;
import it.cgmconsulting.ribatti.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * <p> EP.8 </p>
     * Mostra l'elenco dei Film di un Consumer
     *
     * @param customerId
     * @return
     */
    @GetMapping("/find-all-films-rent-by-one-customer/{customerId}")
    public ResponseEntity<List<FilmRentResponse>> findFilmsOfCustomer(@PathVariable long customerId) {

        if (!customerService.existsById(customerId))
            return new ResponseEntity("L'utente non esistente", HttpStatus.NOT_FOUND);

        List<FilmRentResponse> filmOfCustomer = customerService.findFilmsOfCustomer(customerId);
        return new ResponseEntity(filmOfCustomer, HttpStatus.OK);
    }

}

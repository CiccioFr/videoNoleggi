package it.cgmconsulting.ribatti.controller;

import it.cgmconsulting.ribatti.payload.response.CustomerStoreResponse;
import it.cgmconsulting.ribatti.payload.response.FilmInTimeResponse;
import it.cgmconsulting.ribatti.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    /**
     * <p> EP.5 </p>
     * Conteggio dei clienti di uno Store
     *
     * @param storeName
     * @return
     */
    // @GetMapping("/count-customers-by-store/{storeName}") --> CustomerStoreResponse: store_name, total_customers
    // (N.B. sono da considerare 'clienti' di un determinato store tutti quelli che hanno effettuato almeno un noleggio).
    @GetMapping("/count-customers-by-store/{storeName}")
    public ResponseEntity<List<CustomerStoreResponse>> numberCustomerOfStore(@PathVariable String storeName) {
        CustomerStoreResponse numberCustomerOfStore = storeService.numberCustomerOfStore(storeName);
        return new ResponseEntity(numberCustomerOfStore, HttpStatus.OK);
    }

    /**
     * <p> EP.7 </p>
     * Noleggi in un determinato store in un determinato arco temporale
     * (comprende anche i film non ancora restituiti)
     *
     * @param storeId
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/count-rentals-in-date-range-by-store/{storeId}")
    public ResponseEntity<FilmInTimeResponse> filmInTime(@PathVariable long storeId, @RequestParam String start, @RequestParam String end) {
        FilmInTimeResponse conteggio = storeService.filmInTime(storeId, start, end);
        return new ResponseEntity(conteggio, HttpStatus.OK);
    }
}
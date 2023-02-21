package it.cgmconsulting.ribatti.controller;

import it.cgmconsulting.ribatti.payload.response.CustomerStoreResponse;
import it.cgmconsulting.ribatti.payload.response.FilmInStoreResponse;
import it.cgmconsulting.ribatti.payload.response.FilmTestResponse;
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
}
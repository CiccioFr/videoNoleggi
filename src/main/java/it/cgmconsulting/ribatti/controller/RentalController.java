package it.cgmconsulting.ribatti.controller;

import it.cgmconsulting.ribatti.service.CustomerService;
import it.cgmconsulting.ribatti.service.InventoryService;
import it.cgmconsulting.ribatti.service.RentalService;
import it.cgmconsulting.ribatti.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Validated
public class RentalController {

    @Autowired
    RentalService rentalService;
    @Autowired
    CustomerService customerService;
    @Autowired
    InventoryService inventoryService;
    @Autowired
    StoreService storeService;

//    - add: inserimento rental;
//    - update: aggiornamento solo della data restituzione (rental_return).
//    In questo caso non vi sono suggerimenti sui parametri da passare al controller.
//    N.B.  Il film è noleggiabile solo se almeno una copia è presente in uno store e
//    non risulta a sua volta già noleggiata.

    /**
     * <p> EP.6 </p>
     *
     * @return
     */
//    @PutMapping("/add-update-rental")
//    @Transactional
//    public ResponseEntity addUpdateRental(Long customerId, Long inventoryId/*, Long storeId*/) {
//
//        if (!customerService.findById(customerId).isEmpty())
//            return new ResponseEntity("Customer "+customerId+" non censito", HttpStatus.BAD_REQUEST);
//
//        if (!inventoryService.findById(inventoryId).isEmpty())
//            return new ResponseEntity("Film non presente nello Store", HttpStatus.BAD_REQUEST);
//
////        if (!storeService.findById(storeId).isEmpty())
////            return new ResponseEntity("Store "+storeId+" inesistente", HttpStatus.BAD_REQUEST);
//
//        rentalService.addUpdateRental(customerId, inventoryId/*, storeId*/);
//        return new ResponseEntity("", HttpStatus.OK);
//    }
}

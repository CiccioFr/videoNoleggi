package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.entity.*;
import it.cgmconsulting.ribatti.payload.response.InventoryResponse;
import it.cgmconsulting.ribatti.repository.CustomerRepository;
import it.cgmconsulting.ribatti.repository.InventoryRepository;
import it.cgmconsulting.ribatti.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    /**
     * <p> EP.6 </p>
     */
//    public void addUpdateRental(Long customerId, Long inventoryId/*, Long storeId*/) {
//        Customer customer = customerRepository.findById(customerId).get();
//        Inventory inventory = inventoryRepository.findById(inventoryId).get();
//        Store store = inventory.getStoreId();
//
//        RentalId rId = new RentalId(customer, inventory);
//
//        Optional<Rental> rental = rentalRepository.findById(rId);
//        // query su rental per Inventori con rental_return == null, ricevo elenco:
//        // - vuoto se sono tutti affitati
//        // - popolato se ne ha disponibili
//        List<InventoryResponse> inventoryResponses =rentalRepository.findInventoryWithRentalReturnNull(inventoryId);
//        if (rental.isEmpty()) {  // noleggio
////            Inventory inventory1 = new Inventory(inventory.getStoreId(), );
//            Rental newRental = new Rental(rId);
////            Optional<RentalResponse> i = inventoryService.getInventoryDetails(request.getInventoryId());
//
//        } else {    // Restituisco
//            // inventory se lo mandi stai affitando
//            // se nonlo mandi stai restituendo
//
//        }

//        Rental rental = new Rental(rId);

//        rentalRepository.addUpdateRental();
//    }
}

package it.cgmconsulting.ribatti.repository;

import it.cgmconsulting.ribatti.entity.Rental;
import it.cgmconsulting.ribatti.entity.RentalId;
import it.cgmconsulting.ribatti.payload.response.InventoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, RentalId> {

    // query su rental per Inventori con rental_return == null, ricevo elenco:
    // - vuoto se sono tutti affitati
    // - popolato se ne ha disponibili
    /**
     * <p> EP.6 </p>
     */
//    @Query(value = "SELECT new it.cgmconsulting.ribatti.entity.Rental(" +
//            "r.rentalId.inventoryId.inventoryId, r.rentalId.customerId.customerId) " +
//            "FROM Rental r " +
//            "WHERE rentalReturn = null ")
//    List<InventoryResponse> findInventoryWithRentalReturnNull(@Param("inventoryId") Long inventoryId);
}
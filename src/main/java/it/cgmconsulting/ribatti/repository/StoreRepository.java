package it.cgmconsulting.ribatti.repository;

import it.cgmconsulting.ribatti.entity.Store;
import it.cgmconsulting.ribatti.payload.request.FilmInTimeRequest;
import it.cgmconsulting.ribatti.payload.response.CustomerStoreResponse;
import it.cgmconsulting.ribatti.payload.response.FilmInTimeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {


    /**
     * <p> EP.5 </p>
     * Per lo Store richiesto, restituisce il numero totale dei film in carico
     *
     * @param storeName Nome dello Store
     * @return Response {NomeStore, nrTotFilm}
     */
    @Query(value = "SELECT new it.cgmconsulting.ribatti.payload.response.CustomerStoreResponse(" +
            "r.rentalId.inventoryId.storeId.storeName AS storeName, COUNT(r.rentalId.customerId.customerId)) " +
            "FROM Rental r " +
            "WHERE r.rentalId.inventoryId.storeId.storeName = :storeName " +
            "GROUP BY storeName")
    CustomerStoreResponse findByStoreName(@Param("storeName") String storeName);

    /**
     * EP.7
     * @param start
     * @param end
     */
//    SELECT s.store_name, COUNT(i.inventory_id)
//    FROM Store s
//    INNER JOIN Inventory i ON s.store_id = i.store_id
//    INNER JOIN Rental r ON r.inventory_id = i.inventory_id
//    WHERE s.store_id = 1 AND r.rental_date > '2021-01-01' AND r.rental_return < '2021-10-01'

    @Query(value = "SELECT new it.cgmconsulting.ribatti.payload.response.FilmInTimeResponse(" +
            "s.storeName, COUNT( i.inventoryId) )" +
            "FROM Store s " +
            "INNER JOIN Inventory i ON s.storeId = i.storeId.storeId " +
            "INNER JOIN Rental r ON r.rentalId.inventoryId.inventoryId = i.inventoryId " +
            "WHERE s.storeId = :storeId AND r.rentalId.rentalDate BETWEEN :start AND :end") //r.rentalId.rentalDate > :start AND r.rentalReturn < :end
    FilmInTimeResponse filmInTime(@Param("storeId") long storeId, @Param("start") LocalDate start, @Param("end") LocalDate end);

    // Long countByRentalId_StoreIdAndRentalReturnBetween(long storeId, LocalDateTime startDate, LocalDateTime endDate);

//    @Query(value="SELECT new it.cgmconsulting.ribatti.payload.response.RentalForStore(" +
//            "r.rentalId.inventoryId.storeId.storeName, " +
//            "COUNT(r.rentalId.inventoryId.inventoryId) ) " +
//            "FROM Rental r " +
//            "WHERE r.rentalId.inventoryId.storeId.storeId =:storeId " +
//            "AND r.rentalId.rentalDate BETWEEN :start AND :end")
}
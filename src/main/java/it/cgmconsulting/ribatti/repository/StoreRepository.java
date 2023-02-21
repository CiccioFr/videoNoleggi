package it.cgmconsulting.ribatti.repository;

import it.cgmconsulting.ribatti.entity.Store;
import it.cgmconsulting.ribatti.payload.response.CustomerStoreResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
}
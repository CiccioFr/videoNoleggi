package it.cgmconsulting.ribatti.repository;

import it.cgmconsulting.ribatti.entity.Customer;
import it.cgmconsulting.ribatti.payload.response.FilmRentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * <p> EP.8 </p>
     *
     * @param customerId
     * @return
     */
    @Query(value = "SELECT new it.cgmconsulting.ribatti.payload.response.FilmRentResponse(" +
            "f.filmId, f.title, s.storeName) " +
            "FROM Rental r " +
            "INNER JOIN Customer c ON c.customerId = r.rentalId.customerId " +
            "INNER JOIN Inventory i On r.rentalId.inventoryId = i.inventoryId " +
            "INNER JOIN Store s ON i.storeId.storeId = s.storeId " +
            "INNER JOIN Film f ON i.filmId.filmId = f.filmId " +
            "WHERE c.customerId = :customerId")
    List<FilmRentResponse> findFilmsOfCustomer(@Param("customerId") long customerId);
}

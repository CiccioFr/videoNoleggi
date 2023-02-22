package it.cgmconsulting.ribatti.repository;

import it.cgmconsulting.ribatti.entity.Film;
import it.cgmconsulting.ribatti.payload.response.FilmMaxRentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    /**
     * EP.9
     */
    @Query(value = "SELECT new it.cgmconsulting.ribatti.payload.response.FilmMaxRentResponse(" +
            "f.filmId, f.title, COUNT(*)) " +
            "FROM Film f " +
            "INNER JOIN Inventory i ON f.filmId = i.filmId.filmId " +
            "INNER JOIN Rental r ON i.inventoryId = r.rentalId.inventoryId.inventoryId " +
            "GROUP BY f.title ")
    List<FilmMaxRentResponse> findFilmMaxNrRent();
}
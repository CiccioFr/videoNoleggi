package it.cgmconsulting.ribatti.repository;

import it.cgmconsulting.ribatti.entity.Film;
import it.cgmconsulting.ribatti.payload.response.FilmMaxRentResponse;
import it.cgmconsulting.ribatti.payload.response.FilmResponse;
import it.cgmconsulting.ribatti.payload.response.FilmStoreResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    /**
     * EP.2
     */
    @Query(value = "SELECT new it.cgmconsulting.ribatti.payload.response.FilmStoreResponse(" +
            "f.filmId, f.title, s.storeName) " +
            "FROM Film f " +
            "INNER JOIN Inventory i ON f.filmId = i.filmId.filmId " +
            "INNER JOIN Store s ON i.storeId.storeId = s.storeId " +
            "WHERE f.filmId = :filmId ")
    List<FilmStoreResponse> findFilmInStore(@Param("filmId") Long filmId);

    /**
     * <p> EP.3 </p>
     *
     * @param languageId
     * @return
     */
    @Query(value = "SELECT new it.cgmconsulting.ribatti.payload.response.FilmResponse(" +
            "f.filmId, f.title, f.description, f.releaseYear, f.languageId.languageName) " +
            "FROM Film f " +
            "INNER JOIN Language l ON l.languageId = f.languageId.languageId " +
            "WHERE l.languageId = :languageId")
    List<FilmResponse> findFilmsByLanguage(Long languageId);

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
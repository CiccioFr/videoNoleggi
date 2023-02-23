package it.cgmconsulting.ribatti.controller;

import it.cgmconsulting.ribatti.payload.request.FilmRequest;
import it.cgmconsulting.ribatti.payload.response.FilmMaxRentResponse;
import it.cgmconsulting.ribatti.payload.response.FilmResponse;
import it.cgmconsulting.ribatti.payload.response.FilmStoreResponse;
import it.cgmconsulting.ribatti.service.StaffService;
import it.cgmconsulting.ribatti.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class FilmController {

    @Autowired
    FilmService filmService;
    @Autowired
    StaffService staffService;

    /**
     * EP. 1 - Modifica di un Film
     *
     * @param filmId      id del film da modificare
     * @param filmRequest {String title, String description, int releaseYear}
     * @return ResponseEntity
     */
    @PatchMapping("/update-film/{filmId}")
    @Transactional
    public ResponseEntity updateFilm(@PathVariable long filmId, @Valid @RequestBody FilmRequest filmRequest) {

        if (!filmService.existsById(filmId))
            return new ResponseEntity("Non è stato trovato il Film", HttpStatus.NOT_FOUND);

        filmService.updateFilm(filmId, filmRequest);

        return new ResponseEntity("Il film " + filmRequest.getTitle() + " è stato aggiornato", HttpStatus.OK);
    }

    /**
     * <p> EP.2 </p>
     * Ricerca il film nei vari Store
     *
     * @param filmId
     * @return
     */
    @GetMapping("/find-film-in-store/{filmId}")
    public ResponseEntity findFilmInStore(@PathVariable long filmId) {

        if (!filmService.existsById(filmId))
            return new ResponseEntity("Non è stato trovato il Film", HttpStatus.NOT_FOUND);

        List<FilmStoreResponse> film = filmService.findFilmInStore(filmId);
        return new ResponseEntity(film, HttpStatus.OK);
    }

    /**
     * Ricerca i Film/Films col maggior numero di noleggi
     * <p> EP.9 </p>
     *
     * @return ResponseEntity con List di Films
     */
    @GetMapping("/find-film-with-max-number-of-rent")
    public ResponseEntity findFilmMaxNrRent() {
        List<FilmMaxRentResponse> films = filmService.findFilmMaxNrRentStream();
        return new ResponseEntity(films, HttpStatus.OK);
    }
}
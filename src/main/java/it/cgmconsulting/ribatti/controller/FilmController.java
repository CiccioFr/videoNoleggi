package it.cgmconsulting.ribatti.controller;

import it.cgmconsulting.ribatti.payload.request.FilmRequest;
import it.cgmconsulting.ribatti.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@Validated
public class FilmController {

    @Autowired
    FilmService filmService;

    /**
     * EP. 1 - Modifica di un Film
     *
     * @param filmId      id del film da modificare
     * @param filmRequest {String title, String description, int releaseYear}
     * @return ResponseEntity
     */
    @PatchMapping("/update-film/{filmId}")
    @Transactional
    public ResponseEntity<?> updateFilm(@PathVariable long filmId, @RequestBody FilmRequest filmRequest) {

        if (!filmService.existsById(filmId))
            return new ResponseEntity("Non è stato trovato il Film", HttpStatus.NOT_FOUND);
        filmService.updateFilm(filmId, filmRequest);

        return new ResponseEntity("Il film " + filmRequest.getTitle() + " è stato aggiornato", HttpStatus.OK);
    }
}

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
     * <p> EP.3 </p>
     * Ricerca i film per lingua
     *
     * @return
     */
    @GetMapping("/find-films-by-language/{languageId}")
    public ResponseEntity findFilmsByLanguage(@PathVariable Long languageId) {
        List<FilmResponse> film = filmService.findFilmsByLanguage(languageId);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    /**
     * <p> EP.9 </p>
     * Ricerca i Film/Films col maggior numero di noleggi
     *
     * @return ResponseEntity con List di Films
     */
    @GetMapping("/find-film-with-max-number-of-rent")
    public ResponseEntity findFilmMaxNrRent() {
        List<FilmMaxRentResponse> films = filmService.findFilmMaxNrRentStream();
        return new ResponseEntity(films, HttpStatus.OK);
    }

    /**
     * <p> EP.10 </p>
     * film a cui hanno lavorato tutti gli attori
     *
     * @return
     */
    @GetMapping("/find-films-by-actors")
    public ResponseEntity findFilmsByActors(@RequestParam List<Long> actorId) {

        List<Long> actorNotExist = new ArrayList<>();
        for (Long a : actorId) {
            if (!staffService.existsById(a)) {
                actorNotExist.add(a);
            }
        }
        if (actorNotExist.size() == 1)
            return new ResponseEntity("L'attore con id " + actorNotExist + " non è censito", HttpStatus.NOT_FOUND);

        if (actorNotExist.size() > 1)
            return new ResponseEntity("Gli attori con id " + actorNotExist + " non sono censiti", HttpStatus.NOT_FOUND);

        List<FilmResponse> films = filmService.findFilmsByActors(actorId);
        return new ResponseEntity(films, HttpStatus.OK);
    }
}
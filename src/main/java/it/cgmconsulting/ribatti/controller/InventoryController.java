package it.cgmconsulting.ribatti.controller;

import it.cgmconsulting.ribatti.service.FilmService;
import it.cgmconsulting.ribatti.service.InventoryService;
import it.cgmconsulting.ribatti.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Validated
@Transactional
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    @Autowired
    StoreService storeService;
    @Autowired
    FilmService filmService;

    /**
     * <p> EP.4 </p>
     * Aggiunge un film an uno Store specifico
     *
     * @return
     */
    @Transactional
    @PutMapping("/add-film-to-store/{storeId}/{filmId}")
    public ResponseEntity<?> addFilmToStore(@PathVariable long storeId, @PathVariable long filmId) {

        if (!storeService.existsById(storeId))
            return new ResponseEntity("Non è stato trovato il Negozio", HttpStatus.NOT_FOUND);

        if (!filmService.existsById(filmId))
            return new ResponseEntity("Non è stato trovato il Film", HttpStatus.NOT_FOUND);

        inventoryService.addFilmToStore(storeId, filmId);
        return new ResponseEntity("Film aggiunto all'inventario del negozio", HttpStatus.OK);
    }
}
package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.entity.Film;
import it.cgmconsulting.ribatti.entity.Inventory;
import it.cgmconsulting.ribatti.entity.Store;
import it.cgmconsulting.ribatti.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    StoreService storeService;
    @Autowired
    FilmService filmService;

    /**
     * <p> EP.4 </p>
     * Aggiunge un film an uno Store specifico
     *
     * @param storeId id dello Store a cui aggiungere il Film
     * @param filmId  Film da aggiungere
     */
    public void addFilmToStore(long storeId, long filmId) {

        Store store = storeService.findById(storeId).get();
        Film film = filmService.findById(filmId).get();

        Inventory inventory = new Inventory(store, film);
        inventoryRepository.save(inventory);
    }
}

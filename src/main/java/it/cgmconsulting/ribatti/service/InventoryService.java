package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.entity.Film;
import it.cgmconsulting.ribatti.entity.Inventory;
import it.cgmconsulting.ribatti.entity.Store;
import it.cgmconsulting.ribatti.repository.InventoryRepository;
import it.cgmconsulting.ribatti.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    StoreService storeService;
    @Autowired
    FilmService filmService;

    public void addFilmToStore(long storeId, long filmId) {

        Store store = storeService.findById(storeId).get();
        Film film = filmService.findById(filmId).get();

        Inventory inventory = new Inventory(store, film);
        inventoryRepository.save(inventory);
    }
}

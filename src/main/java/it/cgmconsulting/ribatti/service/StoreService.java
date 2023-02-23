package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.entity.Store;
import it.cgmconsulting.ribatti.payload.response.CustomerStoreResponse;
import it.cgmconsulting.ribatti.payload.response.FilmInTimeResponse;
import it.cgmconsulting.ribatti.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    /**
     * <p> Used by EP.4 </p>
     *
     * @param storeId
     * @return
     */
    public boolean existsById(long storeId) {
        return storeRepository.existsById(storeId);
    }

    /**
     * <p> Used by EP.4 </p>
     *
     * @param storeId
     * @return
     */
    public Optional<Store> findById(long storeId) {
        return storeRepository.findById(storeId);
    }

    /**
     * <p> Used by EP.5 </p>
     * Conteggio dei clienti di uno Store
     *
     * @param storeName
     * @return
     */
    public CustomerStoreResponse numberCustomerOfStore(String storeName) {
        return storeRepository.findByStoreName(storeName);
    }

    /**
     * EP.7
     *
     * @param storeId
     * @param start
     * @param end
     * @return
     */
    public FilmInTimeResponse filmInTime(long storeId, String start, String end) {
        return storeRepository.filmInTimeNativa(storeId, start, end);
    }
}
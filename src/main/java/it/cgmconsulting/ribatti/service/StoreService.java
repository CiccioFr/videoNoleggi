package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.entity.Store;
import it.cgmconsulting.ribatti.payload.response.CustomerStoreResponse;
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
}
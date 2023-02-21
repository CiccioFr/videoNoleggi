package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.entity.Film;
import it.cgmconsulting.ribatti.entity.Store;
import it.cgmconsulting.ribatti.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public boolean existsById(long storeId) {
       return storeRepository.existsById(storeId);
    }

    public Optional<Store> findById(long storeId) {
        return storeRepository.findById(storeId);
    }




}

package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> EP.1 </p>
 */
@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    public boolean existsById(long actorId) {
        return staffRepository.existsById(actorId);
    }
}

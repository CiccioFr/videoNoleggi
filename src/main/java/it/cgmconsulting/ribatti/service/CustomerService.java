package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.entity.Customer;
import it.cgmconsulting.ribatti.payload.response.FilmRentResponse;
import it.cgmconsulting.ribatti.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * <p> EP.8 </p>
     *
     * @param customerId
     * @return
     */
    public List<FilmRentResponse> findFilmsOfCustomer(long customerId) {
        return customerRepository.findFilmsOfCustomer(customerId);
    }

    public boolean existsById(long customerId) {
        return customerRepository.existsById(customerId);
    }

    public Optional<Customer> findById(Long customerId) {
        return customerRepository.findById(customerId);
    }
}

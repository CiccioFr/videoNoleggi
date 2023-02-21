package it.cgmconsulting.ribatti.repository;

import it.cgmconsulting.ribatti.entity.Rental;
import it.cgmconsulting.ribatti.entity.RentalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, RentalId> {
}
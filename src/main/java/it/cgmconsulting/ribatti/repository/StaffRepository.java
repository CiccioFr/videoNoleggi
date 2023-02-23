package it.cgmconsulting.ribatti.repository;

import it.cgmconsulting.ribatti.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p> EP.1 </p>
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}

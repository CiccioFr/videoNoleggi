package it.cgmconsulting.ribatti.repository;

import it.cgmconsulting.ribatti.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p> EP.4-6 </p>
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}

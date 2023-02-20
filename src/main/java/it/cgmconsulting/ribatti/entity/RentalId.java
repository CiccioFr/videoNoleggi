package it.cgmconsulting.ribatti.entity;

import it.cgmconsulting.ribatti.entity.common.CreationRentalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RentalId extends CreationRentalDate implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // decommentare dopo la creazione dell'Entity Inventory
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "inventory_id", nullable = false)
//    private Inventory inventory;
    private long inventoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalId rentalId = (RentalId) o;
        return inventoryId == rentalId.inventoryId && Objects.equals(customer, rentalId.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, inventoryId);
    }
}

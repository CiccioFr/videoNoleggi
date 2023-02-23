package it.cgmconsulting.ribatti.entity;

import it.cgmconsulting.ribatti.entity.common.CreationRentalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * <p> EP.6 </p>
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalId extends CreationRentalDate implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk10_customer"))
    private Customer customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk11_inventory"))
    private Inventory inventoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalId rentalId = (RentalId) o;
        return Objects.equals(customerId, rentalId.customerId) && Objects.equals(inventoryId, rentalId.inventoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, inventoryId);
    }
}

package it.cgmconsulting.ribatti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class Rental {

    @EmbeddedId
    private RentalId rentalId;

    @UpdateTimestamp
    private LocalDateTime rentalReturn;

    public Rental(RentalId rentalId) {
        this.rentalId = rentalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(rentalId, rental.rentalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId);
    }
}

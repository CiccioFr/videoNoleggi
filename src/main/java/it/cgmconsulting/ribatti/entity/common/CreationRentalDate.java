package it.cgmconsulting.ribatti.entity.common;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class CreationRentalDate implements Serializable {

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime rentalDate;
}

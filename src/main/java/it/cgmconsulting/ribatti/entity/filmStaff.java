package it.cgmconsulting.ribatti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class filmStaff {

    @EmbeddedId
    private FilmStaffId filmStaffId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        filmStaff filmStaff = (filmStaff) o;
        return Objects.equals(filmStaffId, filmStaff.filmStaffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmStaffId);
    }
}

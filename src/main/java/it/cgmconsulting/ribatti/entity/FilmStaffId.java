package it.cgmconsulting.ribatti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FilmStaffId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk1_film"))
    private Film filmId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk2_film"))
    private Staff staffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk3_film"))
    private Role roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmStaffId that = (FilmStaffId) o;
        return filmId == that.filmId && staffId == that.staffId && roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, staffId, roleId);
    }
}

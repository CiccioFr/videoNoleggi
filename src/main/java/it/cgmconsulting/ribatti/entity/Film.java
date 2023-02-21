package it.cgmconsulting.ribatti.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity @Getter @Setter @NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long filmId;

    @Column(nullable = false, length = 100)     // unique = true,
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "SMALLINT")
    private int releaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id",
            foreignKey = @ForeignKey(name = "fk_language"))   // nullable = false
    private Language languageId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id",
            foreignKey = @ForeignKey(name = "fk_genre"))      // nullable = false
    private Genre genreId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmId == film.filmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId);
    }
}

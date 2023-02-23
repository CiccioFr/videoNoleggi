package it.cgmconsulting.ribatti.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * <p> EP.3-10 </p>
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmResponse {

    private long filmId;
    private String title;
    private String description;
    private short releaseYear;
    private String languageName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmResponse that = (FilmResponse) o;
        return filmId == that.filmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId);
    }
}

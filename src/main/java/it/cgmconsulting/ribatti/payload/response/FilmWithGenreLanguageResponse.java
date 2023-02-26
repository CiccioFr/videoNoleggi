package it.cgmconsulting.ribatti.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class FilmWithGenreLanguageResponse {

    @JsonIgnore
    private long filmId;
    private String title;
    private String description;
    private short releaseYear;
    private String languageName;
    private String genreName;

}
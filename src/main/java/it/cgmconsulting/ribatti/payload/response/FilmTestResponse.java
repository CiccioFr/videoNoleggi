package it.cgmconsulting.ribatti.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Used by EP. Prova
 */
@Getter @Setter @NoArgsConstructor
public class FilmTestResponse {

    private String title;
    private String description;
    private int releaseYear;
    private long languageName;
    private long genreName;


}

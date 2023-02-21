package it.cgmconsulting.ribatti.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Used by EP.6
 */
@Getter @Setter @NoArgsConstructor
public class FilmInStoreResponse {

    // film
    private long filmId;
    private String title;
    private String description;
    private int releaseYear;
    private String languageName;
    private String genreName;

    // Store
    private long storeId;
    private String storeName;
}

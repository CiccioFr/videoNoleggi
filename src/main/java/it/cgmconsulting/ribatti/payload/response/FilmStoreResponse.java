package it.cgmconsulting.ribatti.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Used by EP.2
 */
@Getter
@Setter
@NoArgsConstructor
public class FilmStoreResponse {

    //    @JsonIgnore
    private long filmId;
    private String title;
    private String storeName;

    public FilmStoreResponse(long filmId, String title, String storeName) {
        this.filmId = filmId;
        this.title = title;
        this.storeName = storeName;
    }
}

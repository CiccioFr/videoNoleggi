package it.cgmconsulting.ribatti.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * EP.7
 */
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class FilmInTimeResponse {

    private String storeName;
    private long conteggio;
}

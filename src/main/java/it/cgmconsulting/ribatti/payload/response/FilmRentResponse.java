package it.cgmconsulting.ribatti.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * EP.8
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmRentResponse {
    private long film_id;
    private String title;
    private String store_name;
}

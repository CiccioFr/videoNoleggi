package it.cgmconsulting.ribatti.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> EP.9 </p>
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmMaxRentResponse {
    private long filmId;
    private String title;
    private long totNoleggi;
}

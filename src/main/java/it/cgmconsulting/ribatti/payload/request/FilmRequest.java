package it.cgmconsulting.ribatti.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <p> EP.1 </p>
 */
@Getter @AllArgsConstructor
public class FilmRequest {

    @NotBlank @Size(min = 1, max = 100)
    private String title;

    @NotBlank @Size(min = 10, max = 65535)
    private String description;

    @Max(2200)
    private short releaseYear;
}
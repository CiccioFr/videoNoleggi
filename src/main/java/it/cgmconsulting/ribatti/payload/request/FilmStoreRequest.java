package it.cgmconsulting.ribatti.payload.request;

import lombok.Getter;

import javax.validation.constraints.*;

// TODO - NON USATO
@Getter
public class FilmStoreRequest {
    @Min(1)
    private long filmId;
    @NotBlank  @NotEmpty @Size(min=5, max=100)
    private String title;
    @NotBlank  @NotEmpty @Size(min=5, max=100)
    private String storeName;
//    @NotBlank @NotNull
//    private String description;
//    @NotNull
//    private short releaseYear;

}
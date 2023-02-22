package it.cgmconsulting.ribatti.payload.request;

import lombok.Getter;

import java.util.Date;

/**
 * EP.7
 */
@Getter
public class FilmInTimeRequest {
    private Date start;
    private Date end;
}

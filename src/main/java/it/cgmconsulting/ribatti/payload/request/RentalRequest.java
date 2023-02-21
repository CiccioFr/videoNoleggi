package it.cgmconsulting.ribatti.payload.request;

import lombok.Getter;

import javax.validation.constraints.Min;

// TODO - NON USATO
@Getter
public class RentalRequest {

    @Min(1)
    private long storeId;

    @Min(1)
    private long customerId;

    @Min(1)
    private long filmId;
}

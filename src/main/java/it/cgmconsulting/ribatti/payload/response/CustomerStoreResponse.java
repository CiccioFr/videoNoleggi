package it.cgmconsulting.ribatti.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Used by EP.5
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CustomerStoreResponse {

    private String storeName;
    private long totalCustomers;

}
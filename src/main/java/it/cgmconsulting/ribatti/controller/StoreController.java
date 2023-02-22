package it.cgmconsulting.ribatti.controller;

import it.cgmconsulting.ribatti.payload.request.FilmInTimeRequest;
import it.cgmconsulting.ribatti.payload.response.CustomerStoreResponse;
import it.cgmconsulting.ribatti.payload.response.FilmInStoreResponse;
import it.cgmconsulting.ribatti.payload.response.FilmInTimeResponse;
import it.cgmconsulting.ribatti.payload.response.FilmTestResponse;
import it.cgmconsulting.ribatti.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    /**
     * <p> EP.5 </p>
     * Conteggio dei clienti di uno Store
     *
     * @param storeName
     * @return
     */
    // @GetMapping("/count-customers-by-store/{storeName}") --> CustomerStoreResponse: store_name, total_customers
    // (N.B. sono da considerare 'clienti' di un determinato store tutti quelli che hanno effettuato almeno un noleggio).
    @GetMapping("/count-customers-by-store/{storeName}")
    public ResponseEntity<List<CustomerStoreResponse>> numberCustomerOfStore(@PathVariable String storeName) {
        CustomerStoreResponse numberCustomerOfStore = storeService.numberCustomerOfStore(storeName);
        return new ResponseEntity(numberCustomerOfStore, HttpStatus.OK);
    }

    /**
     * EP.7
     *
     * @param storeId
     * @param start
     * @param end
     * @return
     */
//    @RequestParam Date start, Date end --> return: conteggio dei noleggi in un
//    determinato store in un determinato arco temporale (comprende anche i film
//            non ancora restituiti).
    @GetMapping("/count-rentals-in-date-range-by-store/{storeId}")
    public ResponseEntity<FilmInTimeResponse> filmInTime(@PathVariable long storeId, @RequestParam String start, @RequestParam String end) {

        System.out.println("Stampa della stringa in ingresso: " + start);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date = LocalDate.parse(start, formatter);

//        Date s=new SimpleDateFormat("yyyy-MM-dd").parse(start);
//        Date e=new SimpleDateFormat("yyyy-MM-dd").parse(end);

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");    // .ofPattern("yyyy-MM-dd HH:mm:ss")
//        LocalDate startDate = LocalDate.parse(start, formatter);
//        LocalDate endDate = LocalDate.parse(end, formatter);

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        // con 2021-10-01
        // java.lang.IllegalArgumentException: Parameter value [2021-07-01] did not match expected type [java.time.LocalDateTime (n/a)]
        // con 2021-10-01 09:00:04
        // java.time.format.DateTimeParseException: Text '2021-07-01 09:00:04' could not be parsed, unparsed text found at index 10

//        LocalDateTime startDate = LocalDateTime.parse(start);
//        LocalDateTime endDate = LocalDateTime.parse(end);
        // con 2021-10-01
        // java.time.format.DateTimeParseException: Text '2021-07-01' could not be parsed at index 10
        // con 2021-07-01 09:00:04
        // java.time.format.DateTimeParseException: Text '2021-07-01 09:00:04' could not be parsed at index 10

//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate;
//        startDate = df.parse(start);
//    //        String newDateString = df.format(startDate);
//    //        System.out.println(newDateString);

//        System.exit(0);

//        LocalDateTime s = LocalDateTime.parse(start);
//        System.out.println("Stampa della stringa --> "+s);

        FilmInTimeResponse conteggio = storeService.filmInTime(storeId, startDate, endDate);
        return new ResponseEntity(conteggio, HttpStatus.OK);
    }
}
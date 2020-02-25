package com.nrjsingh1.reactivespring.controller;


import com.nrjsingh1.reactivespring.model.Reservation;
import com.nrjsingh1.reactivespring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(ReservationResource.ROOM_V_1_RESERVATION)
@CrossOrigin
public class ReservationResource {
    public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";

    private final ReservationService reservationService;

    @Autowired
    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> getReservationById(@PathVariable String id) {
        return reservationService.getReservation(id);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservationMono){
        return reservationService.createReservation(reservationMono);
    }

    @PutMapping(path = "{roomId}",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> updateReservation(@PathVariable String id, @RequestBody Mono<Reservation> reservationMono){
        return reservationService.updateReservation(id, reservationMono);
    }

    @DeleteMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Boolean> deleteReservation(@PathVariable String id){
        return reservationService.deleteReservation(id);
    }
}

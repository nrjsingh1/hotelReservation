package com.nrjsingh1.reactivespring.service;

import com.nrjsingh1.reactivespring.model.Reservation;
import reactor.core.publisher.Mono;

public interface ReservationService {

    Mono<Reservation> getReservation(String  id);

    Mono<Reservation> updateReservation(String id, Mono<Reservation> reservationMono);

    Mono<Reservation> createReservation(Mono<Reservation> reservationMono);

    Mono<Boolean> deleteReservation(String id);
}

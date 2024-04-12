package com.eliottoblinger.springbook.controller;

import java.net.URI;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.eliottoblinger.springbook.dto.ReservationRequest;
import com.eliottoblinger.springbook.model.Reservation;
import com.eliottoblinger.springbook.service.ReservationService;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/")
    public ResponseEntity<List<Reservation>> getAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable("id") Long id) {
        Reservation reservation = reservationService.getById(id);

        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reservation);
    }

    @PostMapping("/")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest request) {
        Reservation reservation = new Reservation();

        reservation.setReservationFrom(request.getReservationFrom());
        reservation.setReservationTo(request.getReservationTo());
        reservation.setNumberOfNights(request.getNumberOfNights());
        reservation.setNumberOfPersons(request.getNumberOfPersons());
        reservation.setRoom(request.getRoom());
        reservation.setTotalPrice(request.getTotalPrice());
        reservation.setUser(request.getUser());
        reservation.setCreatedAt(new Date(System.currentTimeMillis()));

        reservationService.save(reservation);

        try {
            return ResponseEntity.created(new URI("/api/v1/reservations" + reservation.getId())).body(reservation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Long id) {
        Reservation reservation = reservationService.getById(id);

        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }

        reservationService.delete(reservation);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") Long id,
            @RequestBody ReservationRequest request) {
        Reservation reservation = reservationService.getById(id);

        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }

        if (request.getReservationFrom() != null) {
            reservation.setReservationFrom(request.getReservationFrom());
        }

        if (request.getReservationTo() != null) {
            reservation.setReservationTo(request.getReservationTo());
        }

        if (request.getNumberOfNights() != null) {
            reservation.setNumberOfNights(request.getNumberOfNights());
        }

        if (request.getNumberOfPersons() != null) {
            reservation.setNumberOfPersons(request.getNumberOfPersons());
        }

        if (request.getRoom() != null) {
            reservation.setRoom(request.getRoom());
        }

        if (request.getTotalPrice() != null) {
            reservation.setTotalPrice(request.getTotalPrice());
        }

        if (request.getUser() != null) {
            reservation.setUser(request.getUser());
        }

        reservationService.save(reservation);

        return ResponseEntity.ok(reservation);
    }
}

package com.eliottoblinger.springbook.controller;

import java.net.URI;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.eliottoblinger.springbook.dto.RoomRequest;
import com.eliottoblinger.springbook.model.Reservation;
import com.eliottoblinger.springbook.model.Room;
import com.eliottoblinger.springbook.service.RoomService;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/")
    public ResponseEntity<List<Room>> getAll() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getById(@PathVariable("id") Long id) {
        Room room = roomService.getById(id);

        if (room == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(room);
    }

    @PostMapping("/")
    public ResponseEntity<Room> createRoom(@RequestBody RoomRequest request) {
        Room room = new Room();

        room.setName(request.getName());
        room.setDescription(request.getDescription());
        room.setAreAnimalsAllowed(request.getAreAnimalsAllowed());
        room.setIsSmokingAllowed(request.getIsSmokingAllowed());
        room.setNumberOfPersonsAllowed(request.getNumberOfPersonsAllowed());
        room.setImageUrl(request.getImageUrl());
        room.setPricePerNight(request.getPricePerNight());
        room.setReservations(request.getReservations());
        room.setUser(request.getUser());
        room.setCreatedAt(new Date(System.currentTimeMillis()));

        roomService.save(room);

        try {
            return ResponseEntity.created(new URI("/api/v1/rooms" + room.getId())).body(room);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}/reservations")
    public ResponseEntity<Set<Reservation>> getReservations(@PathVariable("id") Long id) {
        Room room = roomService.getById(id);

        if (room == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(room.getReservations());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable("id") Long id) {
        Room room = roomService.getById(id);

        if (room == null) {
            return ResponseEntity.notFound().build();
        }

        roomService.delete(room);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable("id") Long id, @RequestBody RoomRequest request) {
        Room room = roomService.getById(id);

        if (room == null) {
            return ResponseEntity.notFound().build();
        }

        if (request.getName() != null) {
            room.setName(request.getName());
        }

        if (request.getDescription() != null) {
            room.setDescription(request.getDescription());
        }

        if (request.getAreAnimalsAllowed() != null) {
            room.setAreAnimalsAllowed(request.getAreAnimalsAllowed());
        }

        if (request.getIsSmokingAllowed() != null) {
            room.setIsSmokingAllowed(request.getIsSmokingAllowed());
        }

        if (request.getImageUrl() != null) {
            room.setImageUrl(request.getImageUrl());
        }

        if (request.getNumberOfPersonsAllowed() != null) {
            room.setNumberOfPersonsAllowed(request.getNumberOfPersonsAllowed());
        }

        if (request.getPricePerNight() != null) {
            room.setPricePerNight(request.getPricePerNight());
        }

        if (request.getReservations() != null) {
            room.setReservations(request.getReservations());
        }

        if (request.getUser() != null) {
            room.setUser(request.getUser());
        }

        roomService.save(room);

        return ResponseEntity.ok(room);
    }
}

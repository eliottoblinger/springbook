package com.eliottoblinger.springbook.controller;

import java.net.URI;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliottoblinger.springbook.dto.UserRequest;
import com.eliottoblinger.springbook.model.Reservation;
import com.eliottoblinger.springbook.model.Room;
import com.eliottoblinger.springbook.model.User;
import com.eliottoblinger.springbook.service.UserService;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User user = userService.getById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setReservations(request.getReservations());
        user.setRooms(request.getRooms());
        user.setCreatedAt(new Date(System.currentTimeMillis()));

        userService.save(user);

        try {
            return ResponseEntity.created(new URI("/api/v1/users" + user.getId())).body(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}/reservations")
    public ResponseEntity<Set<Reservation>> getReservations(@PathVariable("id") Long id) {
        User user = userService.getById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user.getReservations());
    }

    @GetMapping("/{id}/rooms")
    public ResponseEntity<Set<Room>> getRooms(@PathVariable("id") Long id) {
        User user = userService.getById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user.getRooms());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        User user = userService.getById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.delete(user);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody UserRequest request) {
        User user = userService.getById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }

        if (request.getReservations() != null) {
            user.setReservations(request.getReservations());
        }

        if (request.getRooms() != null) {
            user.setRooms(request.getRooms());
        }

        userService.save(user);

        return ResponseEntity.ok(user);
    }
}

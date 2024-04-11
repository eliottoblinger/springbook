package com.eliottoblinger.springbook.dto;

import com.eliottoblinger.springbook.model.Reservation;
import com.eliottoblinger.springbook.model.Room;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class UserRequest implements Serializable {
    @NotEmpty(message = "Body param username should not be empty.")
    @Size(min = 2, message = "Body param username should have at least 2 characters.")
    private String username;

    private Set<Reservation> reservations;

    private Set<Room> rooms;

    private Date createdAt;

    public UserRequest() {
    }

    public UserRequest(String username, Set<Reservation> reservations, Set<Room> rooms) {
        this.username = username;
        this.reservations = reservations;
        this.rooms = rooms;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
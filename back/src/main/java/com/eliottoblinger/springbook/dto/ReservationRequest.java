package com.eliottoblinger.springbook.dto;

import com.eliottoblinger.springbook.model.Room;
import com.eliottoblinger.springbook.model.User;

import java.io.Serializable;
import java.sql.Date;

public class ReservationRequest implements Serializable {
    private Long id;

    private Integer numberOfPersons;

    private Integer numberOfNights;

    private Integer totalPrice;

    private User user;

    private Room room;

    private Date reservationFrom;

    private Date reservationTo;

    private Date createdAt;

    public ReservationRequest() {
    }

    public ReservationRequest(
            Integer numberOfPersons,
            Integer numberOfNights,
            Integer totalPrice,
            User user,
            Room room,
            Date reservationFrom,
            Date reservationTo) {
        this.numberOfPersons = numberOfPersons;
        this.numberOfNights = numberOfNights;
        this.totalPrice = totalPrice;
        this.user = user;
        this.room = room;
        this.reservationFrom = reservationFrom;
        this.reservationTo = reservationTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getReservationFrom() {
        return reservationFrom;
    }

    public void setReservationFrom(Date reservationFrom) {
        this.reservationFrom = reservationFrom;
    }

    public Date getReservationTo() {
        return reservationTo;
    }

    public void setReservationTo(Date reservationTo) {
        this.reservationTo = reservationTo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
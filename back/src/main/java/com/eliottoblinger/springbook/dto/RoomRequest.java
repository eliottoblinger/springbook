package com.eliottoblinger.springbook.dto;

import com.eliottoblinger.springbook.model.Reservation;
import com.eliottoblinger.springbook.model.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class RoomRequest implements Serializable {
    @NotEmpty(message = "Body param name should not be empty.")
    @Size(min = 2, message = "Body param name should have at least 2 characters.")
    private String name;

    private String description;

    private Integer numberOfPersonsAllowed;

    private String imageUrl;

    private Boolean areAnimalsAllowed;

    private Boolean isSmokingAllowed;

    private Integer pricePerNight;

    private Set<Reservation> reservations;

    private User user;

    private Date createdAt;

    public RoomRequest() {
    }

    public RoomRequest(
            String name,
            String description,
            Integer numberOfPersonsAllowed,
            String imageUrl,
            Boolean areAnimalsAllowed,
            Boolean isSmokingAllowed,
            Integer pricePerNight,
            User user,
            Set<Reservation> reservations) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.numberOfPersonsAllowed = numberOfPersonsAllowed;
        this.areAnimalsAllowed = areAnimalsAllowed;
        this.isSmokingAllowed = isSmokingAllowed;
        this.pricePerNight = pricePerNight;
        this.user = user;
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfPersonsAllowed() {
        return numberOfPersonsAllowed;
    }

    public void setNumberOfPersonsAllowed(Integer numberOfPersonsAllowed) {
        this.numberOfPersonsAllowed = numberOfPersonsAllowed;
    }

    public Boolean getAreAnimalsAllowed() {
        return areAnimalsAllowed;
    }

    public void setAreAnimalsAllowed(Boolean areAnimalsAllowed) {
        this.areAnimalsAllowed = areAnimalsAllowed;
    }

    public Boolean getIsSmokingAllowed() {
        return isSmokingAllowed;
    }

    public void setIsSmokingAllowed(Boolean isSmokingAllowed) {
        this.isSmokingAllowed = isSmokingAllowed;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
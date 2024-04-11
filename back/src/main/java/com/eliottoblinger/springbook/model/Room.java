package com.eliottoblinger.springbook.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String description;

    private Integer numberOfPersonsAllowed;

    private Boolean areAnimalsAllowed;

    private Boolean isSmokingAllowed;

    private Integer pricePerNight;

    @OneToMany(mappedBy="room")
    private Set<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @CreatedDate
    private Date createdAt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Integer getNumberOfPersonsAllowed() {
        return numberOfPersonsAllowed;
    }

    public void setNumberOfPersonsAllowed(Integer numberOfPersonsAllowed) {
        this.numberOfPersonsAllowed = numberOfPersonsAllowed;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
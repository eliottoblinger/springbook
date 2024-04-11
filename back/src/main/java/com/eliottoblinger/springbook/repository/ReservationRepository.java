package com.eliottoblinger.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliottoblinger.springbook.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
package com.eliottoblinger.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliottoblinger.springbook.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}

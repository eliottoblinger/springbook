package com.eliottoblinger.springbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliottoblinger.springbook.model.Room;
import com.eliottoblinger.springbook.repository.RoomRepository;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Room getById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void delete(Room room) {
        roomRepository.delete(room);
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
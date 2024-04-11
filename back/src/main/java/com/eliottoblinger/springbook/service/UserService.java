package com.eliottoblinger.springbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliottoblinger.springbook.model.User;
import com.eliottoblinger.springbook.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public User save(User user) {
        return UserRepository.save(user);
    }

    public User getById(Long id) {
        return UserRepository.findById(id).orElse(null);
    }

    public void delete(User user) {
        UserRepository.delete(user);
    }

    public List<User> findAll() {
        return UserRepository.findAll();
    }
}
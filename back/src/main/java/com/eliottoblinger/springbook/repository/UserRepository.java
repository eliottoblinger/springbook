package com.eliottoblinger.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliottoblinger.springbook.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
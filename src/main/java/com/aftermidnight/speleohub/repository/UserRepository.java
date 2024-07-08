package com.aftermidnight.speleohub.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aftermidnight.speleohub.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Page<User> findAll(Pageable pageable);
}

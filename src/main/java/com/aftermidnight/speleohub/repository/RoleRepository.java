package com.aftermidnight.speleohub.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.aftermidnight.speleohub.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

    @NonNull
    Page<Role> findAll(@NonNull Pageable pageable);
}

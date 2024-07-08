package com.aftermidnight.speleohub.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.aftermidnight.speleohub.model.Privilege;


public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    @NonNull
    Page<Privilege> findAll(@NonNull Pageable pageable);
}

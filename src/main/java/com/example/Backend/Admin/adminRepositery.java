package com.example.Backend.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface adminRepositery extends JpaRepository<admin, Long> {

    @Query ("Select a from admin a where a.email =?1")
    Optional<admin> findadminByEmail(String email);
}

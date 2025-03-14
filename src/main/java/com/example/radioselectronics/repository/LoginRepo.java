package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginRepo extends JpaRepository<Login, UUID> {
    boolean existsByEmail(String email);
}
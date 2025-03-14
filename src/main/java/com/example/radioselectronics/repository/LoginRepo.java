package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.Login;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginRepo extends JpaRepository<Login, UUID> {
    @Email
    boolean existsByEmail(String email);
}
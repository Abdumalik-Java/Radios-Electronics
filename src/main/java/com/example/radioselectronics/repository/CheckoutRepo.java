package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.Checkout;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckoutRepo extends JpaRepository<Checkout, UUID> {
    boolean existsByEmail(@Email String email);
}

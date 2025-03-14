package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartItemsRepo extends JpaRepository<CartItems, UUID> {
}
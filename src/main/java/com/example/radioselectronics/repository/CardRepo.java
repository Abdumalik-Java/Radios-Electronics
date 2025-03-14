package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepo extends JpaRepository<Card, UUID> {
}

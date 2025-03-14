package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.About;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AboutRepo extends JpaRepository<About, UUID> {
}
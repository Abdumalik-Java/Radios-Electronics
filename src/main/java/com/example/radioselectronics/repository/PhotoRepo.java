package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhotoRepo extends JpaRepository<Photo, UUID> {
}
package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagsRepo extends JpaRepository<Tags, UUID> {
}

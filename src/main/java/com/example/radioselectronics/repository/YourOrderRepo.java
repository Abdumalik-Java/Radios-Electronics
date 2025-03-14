package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.YourOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YourOrderRepo extends JpaRepository<YourOrder, UUID> {
}

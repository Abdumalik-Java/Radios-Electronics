package com.example.radioselectronics.repository;

import com.example.radioselectronics.model.Total;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TotalRepo extends JpaRepository<Total, UUID> {
}

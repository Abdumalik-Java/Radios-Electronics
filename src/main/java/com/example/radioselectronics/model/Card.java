package com.example.radioselectronics.model;

import com.example.radioselectronics.model.entity.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private Integer cardNumber;
    @Column(nullable = false)
    private LocalDateTime expiryDate;
    @Column(nullable = false, unique = true)
    private Long cvvNumber;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

}
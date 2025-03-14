package com.example.radioselectronics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Total {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private Double subTotalPrice;
    @Column(nullable = false)
    private Double totalPrice;
    @Column(nullable = false)
    private Double shippingCost;

}
package com.example.radioselectronics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    private Total subTotal;
    @OneToOne
    private Product name;
    @OneToOne
    private Product price;
    @ManyToMany
    private List<Product> productId;
    @CreatedDate
    private LocalDateTime createdTime = LocalDateTime.now();

}
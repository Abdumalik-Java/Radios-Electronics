package com.example.radioselectronics.model;

import com.example.radioselectronics.model.entity.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    private Photo photoId;
    @OneToOne
    private Comment commentId;
    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now();
    @Enumerated
    private Status status;

}
package abdumalik.dev.radioselectronics.model;

import abdumalik.dev.radioselectronics.model.entity.Status;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer rate;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer count;
    @ManyToOne
    private Category category;
    @OneToOne
    private Tags tags;
    @Enumerated
    private Status status;
    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now();

}
package abdumalik.dev.radioselectronics.model;

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
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now();

}
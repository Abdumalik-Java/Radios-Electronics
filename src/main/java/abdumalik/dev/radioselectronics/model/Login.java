package abdumalik.dev.radioselectronics.model;

import abdumalik.dev.radioselectronics.model.entity.Role;
import abdumalik.dev.radioselectronics.model.entity.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String username;
    @Email
    private String email;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Role role;
    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now();

}
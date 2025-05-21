package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Login;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginRepo extends JpaRepository<Login, UUID> {
    boolean existsByEmail(@Email String email);
}
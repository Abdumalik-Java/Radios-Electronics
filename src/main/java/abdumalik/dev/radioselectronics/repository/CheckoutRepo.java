package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Checkout;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckoutRepo extends JpaRepository<Checkout, UUID> {
    boolean existsByEmail(@Email String email);
}

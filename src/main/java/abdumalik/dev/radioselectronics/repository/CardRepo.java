package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepo extends JpaRepository<Card, UUID> {
}

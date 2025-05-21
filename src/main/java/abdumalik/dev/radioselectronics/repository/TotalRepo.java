package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Total;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TotalRepo extends JpaRepository<Total, UUID> {
}

package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.YourOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YourOrderRepo extends JpaRepository<YourOrder, UUID> {
}

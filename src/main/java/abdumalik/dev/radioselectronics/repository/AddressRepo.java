package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepo extends JpaRepository<Address, UUID> {
}
package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, UUID> {
    Optional<Product> findByName(String name);
}
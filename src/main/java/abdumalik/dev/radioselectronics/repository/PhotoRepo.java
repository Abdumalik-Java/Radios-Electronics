package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhotoRepo extends JpaRepository<Photo, UUID> {
}
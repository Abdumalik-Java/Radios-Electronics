package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikeRepo extends JpaRepository<Like, UUID> {
}
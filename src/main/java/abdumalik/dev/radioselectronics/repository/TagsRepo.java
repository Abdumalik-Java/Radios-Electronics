package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagsRepo extends JpaRepository<Tags, UUID> {
}

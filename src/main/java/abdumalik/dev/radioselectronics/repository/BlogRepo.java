package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogRepo extends JpaRepository<Blog, UUID> {
}

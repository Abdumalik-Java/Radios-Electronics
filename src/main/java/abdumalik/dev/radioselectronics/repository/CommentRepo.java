package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepo extends JpaRepository<Comment, UUID> {
}
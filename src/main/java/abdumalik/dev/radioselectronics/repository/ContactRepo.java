package abdumalik.dev.radioselectronics.repository;

import abdumalik.dev.radioselectronics.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepo extends JpaRepository<Contact, UUID> {
}
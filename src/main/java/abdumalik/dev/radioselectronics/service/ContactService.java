package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.ContactDto;
import abdumalik.dev.radioselectronics.model.Contact;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    ContactRepo repo;

    public List<Contact> getAll() {
        return repo.findAll();
    }

    public Contact getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setText(contactDto.getText());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        repo.save(contact);
        return new Result("Contact information created successfully", true);
    }

    public Result update(ContactDto contactDto, UUID id) {
        Optional<Contact> byId = repo.findById(id);
        if (byId.isPresent()) {
            Contact contact = byId.get();
            contact.setText(contactDto.getText());
            contact.setPhoneNumber(contactDto.getPhoneNumber());
            repo.save(contact);
            return new Result("Contact information updated successfully", true);
        }
        return new Result("Contact information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Contact> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Contact information deleted successfully", true);
        }
        return new Result("Contact information not found", false);
    }

}
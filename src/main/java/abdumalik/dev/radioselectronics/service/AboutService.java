package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.AboutDto;
import abdumalik.dev.radioselectronics.model.About;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.repository.AboutRepo;
import abdumalik.dev.radioselectronics.repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AboutService {

    @Autowired
    AboutRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    public List<About> getAllAbout() {
        return repo.findAll();
    }

    public About getAboutById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(AboutDto dto) {
        About about = new About();
        about.setName(dto.getName());
        about.setDescription(dto.getDescription());
        about.setPhoto(photoRepo.findById(dto.getPhotoId()).get());
        repo.save(about);
        return new Result("About information created successfully", true);
    }

    public Result update(AboutDto dto, UUID id) {
        Optional<About> byId = repo.findById(id);
        if (byId.isPresent()) {
            About about = byId.get();
            about.setName(dto.getName());
            about.setDescription(dto.getDescription());
            about.setPhoto(photoRepo.findById(dto.getPhotoId()).get());
            repo.save(about);
            return new Result("About information updated successfully", true);
        }
        return new Result("About information not found", false);
    }

    public Result delete(UUID id) {
        Optional<About> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("About information deleted successfully", true);
        }
        return new Result("About information not found", false);
    }

}
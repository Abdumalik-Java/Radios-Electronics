package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.PhotoDto;
import abdumalik.dev.radioselectronics.model.Photo;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoService {

    @Autowired
    PhotoRepo repo;

    public List<Photo> getAll() {
        return repo.findAll();
    }

    public Photo getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(PhotoDto dto) {
        Photo photo = new Photo();
        photo.setName(dto.getName());
        photo.setSize(dto.getSize());
        photo.setPath(dto.getPath());
        repo.save(photo);
        return new Result("Photo information created successfully", true);
    }

    public Result update(PhotoDto dto, UUID id) {
        Optional<Photo> byId = repo.findById(id);
        if (byId.isPresent()) {
            Photo photo = byId.get();
            photo.setName(dto.getName());
            photo.setSize(dto.getSize());
            photo.setPath(dto.getPath());
            repo.save(photo);
            return new Result("Photo information updated successfully", true);
        }
        return new Result("Photo information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Photo> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.deleteById(id);
            return new Result("Photo information deleted successfully", true);
        }
        return new Result("Photo information not found", false);
    }

}
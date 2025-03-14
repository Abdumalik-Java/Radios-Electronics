package com.example.radioselectronics.service;

import com.example.radioselectronics.dto.TagsDto;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.model.Tags;
import com.example.radioselectronics.repository.TagsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TagsService {

    @Autowired
    TagsRepo repo;

    public List<Tags> getTags() {
        return repo.findAll();
    }

    public Tags getTag(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(TagsDto dto) {
        Tags tags = new Tags();
        tags.setName(dto.getName());
        repo.save(tags);
        return new Result("Tags information created successfully", true);
    }

    public Result update(TagsDto dto, UUID id) {
        Optional<Tags> byId = repo.findById(id);
        if (byId.isPresent()) {
            Tags tags = byId.get();
            tags.setName(dto.getName());
            repo.save(tags);
            return new Result("Tags information updated successfully", true);
        }
        return new Result("Tags information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Tags> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Tags information deleted successfully", true);
        }
        return new Result("Tags information not found", false);
    }

}
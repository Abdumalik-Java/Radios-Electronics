package com.example.radioselectronics.controller;

import com.example.radioselectronics.dto.TagsDto;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.model.Tags;
import com.example.radioselectronics.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    TagsService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<Tags> tags = service.getTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        Tags tag = service.getTag(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody TagsDto tagsDto) {
        Result result = service.create(tagsDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody TagsDto tagsDto) {
        Result update = service.update(tagsDto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result result = service.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
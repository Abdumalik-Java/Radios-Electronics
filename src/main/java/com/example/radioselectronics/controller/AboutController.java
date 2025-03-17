package com.example.radioselectronics.controller;

import com.example.radioselectronics.dto.AboutDto;
import com.example.radioselectronics.model.About;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/about")
public class AboutController {

    @Autowired
    AboutService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<About> allAbout = service.getAllAbout();
        return new ResponseEntity<>(allAbout, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        About aboutById = service.getAboutById(id);
        return new ResponseEntity<>(aboutById, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody AboutDto aboutDto) {
        Result result = service.create(aboutDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody AboutDto aboutDto) {
        Result update = service.update(aboutDto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result result = service.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
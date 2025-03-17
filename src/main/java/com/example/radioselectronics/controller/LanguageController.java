package com.example.radioselectronics.controller;

import com.example.radioselectronics.dto.LanguageDto;
import com.example.radioselectronics.model.Language;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<Language> all = service.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        Language byId = service.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readByName(@PathVariable String name) {
        Language byName = service.findByName(name);
        return new ResponseEntity<>(byName, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody LanguageDto languageDto) {
        Result result = service.create(languageDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody LanguageDto languageDto) {
        Result update = service.update(languageDto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result result = service.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
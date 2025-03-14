package com.example.radioselectronics.controller;

import com.example.radioselectronics.dto.TotalDto;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.model.Total;
import com.example.radioselectronics.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/total")
public class TotalController {

    @Autowired
    TotalService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<Total> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        Total byId = service.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'USER')")
    public HttpEntity<?> create(@RequestBody TotalDto dto) {
        Result result = service.create(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'USER')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody TotalDto dto) {
        Result update = service.update(dto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'USER')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result delete = service.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
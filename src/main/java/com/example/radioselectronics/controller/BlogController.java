package com.example.radioselectronics.controller;

import com.example.radioselectronics.dto.BlogDto;
import com.example.radioselectronics.model.Blog;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<Blog> all = blogService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        Blog blog = blogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody BlogDto blogDto) {
        Result result = blogService.create(blogDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody BlogDto blogDto) {
        Result update = blogService.update(blogDto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result delete = blogService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
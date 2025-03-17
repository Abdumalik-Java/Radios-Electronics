package com.example.radioselectronics.controller;

import com.example.radioselectronics.dto.LikeDto;
import com.example.radioselectronics.model.Like;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<Like> likes = likeService.getLikes();
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        Like like = likeService.getLike(id);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> create(@RequestBody LikeDto dto) {
        Result like = likeService.createLike(dto);
        return new ResponseEntity<>(like, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody LikeDto dto) {
        Result like = likeService.updateLike(id, dto);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result like = likeService.deleteLike(id);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

}
package com.example.radioselectronics.controller;

import com.example.radioselectronics.dto.CommentDto;
import com.example.radioselectronics.model.Comment;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<Comment> allComments = commentService.getAllComments();
        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        Comment comment = commentService.getCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> create(@RequestBody CommentDto commentDto) {
        Result comment = commentService.createComment(commentDto);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody CommentDto commentDto) {
        Result comment = commentService.updateComment(id, commentDto);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result comment = commentService.deleteComment(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
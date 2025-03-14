package com.example.radioselectronics.service;

import com.example.radioselectronics.dto.CommentDto;
import com.example.radioselectronics.model.Comment;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.repository.CommentRepo;
import com.example.radioselectronics.repository.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    CommentRepo repo;

    @Autowired
    LikeRepo likeRepo;

    public List<Comment> getAllComments() {
        return repo.findAll();
    }

    public Comment getCommentById(UUID id) {
        return repo.findById(id).get();
    }

    public Result createComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setDescription(commentDto.getDescription());
        comment.setLike(likeRepo.findById(commentDto.getLikeId()).get());
        repo.save(comment);
        return new Result("Comment information created and saved successfully", true);
    }

    public Result updateComment(UUID id, CommentDto commentDto) {
        Optional<Comment> byId = repo.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();
            comment.setText(commentDto.getText());
            comment.setDescription(commentDto.getDescription());
            comment.setLike(likeRepo.findById(commentDto.getLikeId()).get());
            repo.save(comment);
            return new Result("Comment information updated and saved successfully", true);
        }
        return new Result("Comment information not found", false);
    }

    public Result deleteComment(UUID id) {
        Optional<Comment> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Comment information deleted and saved successfully", true);
        }
        return new Result("Comment information not found", false);
    }

}
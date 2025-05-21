package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.BlogDto;
import abdumalik.dev.radioselectronics.model.Blog;
import abdumalik.dev.radioselectronics.model.Comment;
import abdumalik.dev.radioselectronics.model.Photo;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.repository.BlogRepo;
import abdumalik.dev.radioselectronics.repository.CommentRepo;
import abdumalik.dev.radioselectronics.repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogService {

    @Autowired
    BlogRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    CommentRepo commentRepo;

    public List<Blog> findAll() {
        return repo.findAll();
    }

    public Blog findById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(BlogDto dto) {
        Blog blog = new Blog();
        blog.setName(dto.getName());
        blog.setDescription(dto.getDescription());
        Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
        Photo photo = byId.get();
        blog.setPhotoId(photo);

        Optional<Comment> byId1 = commentRepo.findById(dto.getCommentId());
        Comment comment = byId1.get();
        blog.setCommentId(comment);

        repo.save(blog);
        return new Result("Blog information created successfully", true);
    }

    public Result update(BlogDto dto, UUID id) {
        Optional<Blog> byId = repo.findById(id);
        if (byId.isPresent()) {
            Blog blog = byId.get();
            blog.setName(dto.getName());
            blog.setDescription(dto.getDescription());

            Optional<Photo> byPhotoId = photoRepo.findById(dto.getPhotoId());
            Photo photo = byPhotoId.get();
            blog.setPhotoId(photo);

            Optional<Comment> byCommentId = commentRepo.findById(dto.getCommentId());
            Comment comment = byCommentId.get();
            blog.setCommentId(comment);

            repo.save(blog);
            return new Result("Blog information updated successfully", true);
        }
        return new Result("Blog information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Blog> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Blog information deleted successfully", true);
        }
        return new Result("Blog information not found", false);
    }

}
package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.LikeDto;
import abdumalik.dev.radioselectronics.model.Like;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.repository.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LikeService {

    @Autowired
    LikeRepo repo;

    public List<Like> getLikes() {
        return repo.findAll();
    }

    public Like getLike(UUID id) {
        return repo.findById(id).get();
    }

    public Result createLike(LikeDto likeDto) {
        Like like = new Like();
        like.setName(likeDto.getName());
        like.setCount(likeDto.getCount());
        repo.save(like);
        return new Result("Like information successfully created", true);
    }

    public Result updateLike(UUID id, LikeDto likeDto) {
        Optional<Like> byId = repo.findById(id);
        if (byId.isPresent()) {
            Like like = byId.get();
            like.setName(likeDto.getName());
            like.setCount(likeDto.getCount());
            repo.save(like);
            return new Result("Like information successfully updated", true);
        }
        return new Result("Like information not found", false);
    }

    public Result deleteLike(UUID id) {
        Optional<Like> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Like information successfully deleted", true);
        }
        return new Result("Like information not found", false);
    }

}
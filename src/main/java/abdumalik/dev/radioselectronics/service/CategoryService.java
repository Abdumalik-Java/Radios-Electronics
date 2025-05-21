package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.CategoryDto;
import abdumalik.dev.radioselectronics.model.Category;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo repo;

    public List<Category> findAll() {
        return repo.findAll();
    }

    public Category findById(UUID id) {
        return repo.findById(id).get();
    }

    public Category findByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(CategoryDto categoryDto) {
        boolean b = repo.existsByName(categoryDto.getName());
        if (b) {
            return new Result("Product name is already used", false);
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        repo.save(category);
        return new Result("Category information created successfully", true);
    }

    public Result update(CategoryDto categoryDto, UUID id) {
        Optional<Category> byId = repo.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            repo.save(category);
            return new Result("Category information updated successfully", true);
        }
        return new Result("Category information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Category> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Category information deleted successfully", true);
        }
        return new Result("Category information not found", false);
    }

}
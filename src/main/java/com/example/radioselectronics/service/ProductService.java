package com.example.radioselectronics.service;

import com.example.radioselectronics.dto.ProductDto;
import com.example.radioselectronics.model.Product;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.repository.CategoryRepo;
import com.example.radioselectronics.repository.ProductRepo;
import com.example.radioselectronics.repository.TagsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    TagsRepo tagsRepo;

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProduct(UUID id) {
        return repo.findById(id).get();
    }

    public Product getProductByName(String name) {
        return repo.findByName(name).get();
    }

    public Result createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setRate(productDto.getRate());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setModel(productDto.getModel());
        product.setCount(productDto.getCount());
        repo.save(product);
        return new Result("Product information created successfully", true);
    }

    public Result updateProduct(UUID id, ProductDto productDto) {
        Optional<Product> byId = repo.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            product.setName(productDto.getName());
            product.setRate(productDto.getRate());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setModel(productDto.getModel());
            product.setCount(productDto.getCount());
            repo.save(product);
            return new Result("Product information updated successfully", true);
        }
        return new Result("Product information not found", false);
    }

    public Result deleteProduct(UUID id) {
        Optional<Product> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Product information deleted successfully", true);
        }
        return new Result("Product information not found", false);
    }

}
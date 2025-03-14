package com.example.radioselectronics.service;

import com.example.radioselectronics.dto.CheckoutDto;
import com.example.radioselectronics.model.Checkout;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.repository.CheckoutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CheckoutService {

    @Autowired
    CheckoutRepo repo;

    public List<Checkout> getAllCheckouts() {
        return repo.findAll();
    }

    public Checkout getCheckoutById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(CheckoutDto dto) {
        Checkout checkout = new Checkout();
        checkout.setFirstName(dto.getFirstName());
        checkout.setLastName(dto.getLastName());
        checkout.setEmail(dto.getEmail());
        checkout.setPhone(dto.getPhone());
        checkout.setPassword(dto.getPassword());
        checkout.setCompanyName(dto.getCompanyName());
        repo.save(checkout);
        return new Result("Checkout information created successfully", true);
    }

    public Result update(CheckoutDto dto, UUID id) {
        Optional<Checkout> byId = repo.findById(id);
        if (byId.isPresent()) {
            Checkout checkout = byId.get();
            checkout.setFirstName(dto.getFirstName());
            checkout.setLastName(dto.getLastName());
            checkout.setEmail(dto.getEmail());
            checkout.setPhone(dto.getPhone());
            checkout.setPassword(dto.getPassword());
            checkout.setCompanyName(dto.getCompanyName());
            repo.save(checkout);
            return new Result("Checkout information updated successfully", true);
        }
        return new Result("Checkout information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Checkout> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Checkout information deleted successfully", true);
        }
        return new Result("Checkout information not found", false);
    }

}
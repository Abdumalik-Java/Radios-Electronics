package com.example.radioselectronics.service;

import com.example.radioselectronics.dto.LoginDto;
import com.example.radioselectronics.model.Login;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    LoginRepo repo;

    public List<Login> findAll() {
        return repo.findAll();
    }

    public Login findById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(LoginDto dto) {
        boolean b = repo.existsByEmail(dto.getEmail());
        if (b) {
            return new Result("This email is already exist", false);
        }
        Login login = new Login();
        login.setUsername(dto.getUsername());
        login.setEmail(dto.getEmail());
        login.setPassword(dto.getPassword());
        repo.save(login);
        return new Result("Successfully created login information", true);
    }

    public Result update(LoginDto dto, UUID id) {
        Optional<Login> byId = repo.findById(id);
        if (byId.isPresent()) {
            Login login = byId.get();
            login.setUsername(dto.getUsername());
            login.setEmail(dto.getEmail());
            login.setPassword(dto.getPassword());
            repo.save(login);
            return new Result("Successfully updated login information", true);
        }
        return new Result("Login information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Login> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Successfully deleted login information", true);
        }
        return new Result("Login information not found", false);
    }

}
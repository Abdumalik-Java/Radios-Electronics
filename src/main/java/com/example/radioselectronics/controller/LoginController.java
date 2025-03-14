package com.example.radioselectronics.controller;

import com.example.radioselectronics.dto.LoginDto;
import com.example.radioselectronics.model.Login;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<Login> all = loginService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        Login login = loginService.findById(id);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'USER')")
    public HttpEntity<?> create(@RequestBody LoginDto loginDto) {
        Result result = loginService.create(loginDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody LoginDto loginDto) {
        Result update = loginService.update(loginDto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'USER')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result delete = loginService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
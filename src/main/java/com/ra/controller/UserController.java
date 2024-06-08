package com.ra.controller;

import com.ra.model.dto.request.UserRequestDTO;
import com.ra.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> index(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserRequestDTO requestDTO){
        return new ResponseEntity<>(userService.save(requestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }
}

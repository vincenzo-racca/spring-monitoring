package com.vincenzoracca.springmonitoring.client.controller;


import com.vincenzoracca.springmonitoring.client.entities.User;
import com.vincenzoracca.springmonitoring.client.repos.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<User> users = userRepository.findAll();
        if (CollectionUtils.isEmpty(users)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

package com.nicascript.notificationpayments.controller;

import com.nicascript.notificationpayments.dto.entity.UserEntity;
import com.nicascript.notificationpayments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("list")
    public ResponseEntity<List<UserEntity>> list() {
        List<UserEntity> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(UserEntity user) {
        UserEntity userEntity = userRepository.save(user);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }
}

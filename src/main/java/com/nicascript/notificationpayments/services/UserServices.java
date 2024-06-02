package com.nicascript.notificationpayments.services;

import com.nicascript.notificationpayments.dto.entity.UserEntity;
import com.nicascript.notificationpayments.repository.UserRepository;
import jakarta.servlet.http.PushBuilder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServices {

    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}

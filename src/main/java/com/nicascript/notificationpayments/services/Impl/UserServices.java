package com.nicascript.notificationpayments.services.Impl;

import com.nicascript.notificationpayments.dto.entity.UserEntity;
import com.nicascript.notificationpayments.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

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

    public UserEntity loginAsCustomer(String username, String password) {
        var result = new UserEntity();
        result.setName(username);
        result.setPassword(password);
        if (result.getName().equals(username) && result.getPassword().equals(password)) {
            return result;
        }
        throw new EntityNotFoundException("No se encontro el Usuario");
    }
    public  UserEntity createUser(UserEntity user) {
        return userRepository.save(user);

    }
}

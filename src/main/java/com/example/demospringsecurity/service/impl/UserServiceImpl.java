package com.example.demospringsecurity.service.impl;

import com.example.demospringsecurity.domain.User;
import com.example.demospringsecurity.repository.UserRepository;
import com.example.demospringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}

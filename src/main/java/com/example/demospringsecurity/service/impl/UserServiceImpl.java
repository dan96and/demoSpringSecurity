package com.example.demospringsecurity.service.impl;

import com.example.demospringsecurity.domain.User;
import com.example.demospringsecurity.repository.UserRepository;
import com.example.demospringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Boolean registerUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return true ;
    }

    @Override
    public Boolean loginUser(User user) {

        User userBBDD = userRepository.findByUsername(user.getUsername());

        if (userBBDD == null) {
            return false;
        }else return userBBDD.getUsername().equals(user.getUsername());

    }

    @Override
    public User findUserByUsername(String username) {
        return findUserByUsername(username);
    }
}

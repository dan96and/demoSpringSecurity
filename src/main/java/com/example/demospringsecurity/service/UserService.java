package com.example.demospringsecurity.service;

import com.example.demospringsecurity.domain.User;


public interface UserService {

    Boolean registerUser(User user);

    Boolean loginUser(User user);

    User findUserByUsername(String username);

}

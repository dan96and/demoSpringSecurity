package com.example.demospringsecurity.service;

import com.example.demospringsecurity.domain.User;


public interface UserService {

    Boolean registerUser(User user);

    User findUserByUsername(String username);

}

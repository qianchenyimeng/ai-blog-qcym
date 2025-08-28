package com.example.blog.service;

import com.example.blog.entity.User;
import com.example.blog.dto.UserDto;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByUsername(String username);

    User findByEmail(String email);
}

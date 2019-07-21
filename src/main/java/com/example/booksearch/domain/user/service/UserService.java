package com.example.booksearch.domain.user.service;

import com.example.booksearch.domain.user.entity.User;

public interface UserService {
    User signUp(String userId, String pwd);
}

package com.example.booksearch.domain.user.service;

import com.example.booksearch.domain.user.dto.UserCheckDto;

public interface UserService {
    UserCheckDto signUp(String userId, String pwd);

    UserCheckDto checkLogin(String userId, String pwd);
}

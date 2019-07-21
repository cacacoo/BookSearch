package com.example.booksearch.web;

import com.example.booksearch.domain.user.entity.User;
import com.example.booksearch.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/sign/up")
    public User signUp(String userId, String pwd) {
        return userService.signUp(userId, pwd);
    }

//    @GetMapping("/sign/in")
//    public
}

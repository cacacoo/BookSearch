package com.example.booksearch.web;

import com.example.booksearch.domain.user.dto.UserCheckDto;
import com.example.booksearch.domain.user.entity.User;
import com.example.booksearch.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/sign/up")
    public UserCheckDto signUp(@RequestParam String userId,  @RequestParam String pwd) {
        return userService.signUp(userId, pwd);
    }

    @GetMapping("/log/in")
    public UserCheckDto logIn(@RequestParam String userId,  @RequestParam String pwd) {
        return userService.checkLogin(userId, pwd);
    }

}

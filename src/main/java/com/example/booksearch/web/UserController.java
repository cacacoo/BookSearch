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

    @GetMapping("/log/out")
    public boolean logIn(@RequestParam String userId) {
        //만약 세션을 이용하고 있다면 세션을 지워주는 용도로 쓰일 예정
        return true;
    }
}

package com.example.booksearch.web;

import com.example.booksearch.domain.user.entity.UserSearchHistory;
import com.example.booksearch.domain.user.service.UserSearchHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserSearchHistoryController {

    @Autowired
    private UserSearchHistoryService userSearchHistoryService;

    @PutMapping("/user/search")
    public boolean saveSearchHistory(@RequestParam String userId, @RequestParam String keyword) {
        return userSearchHistoryService.save(userId, keyword);
    }

    @GetMapping("/user/search")
    public List<UserSearchHistory> readSearchHistory(@RequestParam String userId) {
        return userSearchHistoryService.findSearchHistory(userId);
    }
}

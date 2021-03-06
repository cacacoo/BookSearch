package com.example.booksearch.domain.user.service;

import com.example.booksearch.domain.user.entity.UserSearchHistory;

import java.util.List;

public interface UserSearchHistoryService {
    UserSearchHistory save(String userId, String keyword);

    List<UserSearchHistory> findSearchHistory(String userId);
}

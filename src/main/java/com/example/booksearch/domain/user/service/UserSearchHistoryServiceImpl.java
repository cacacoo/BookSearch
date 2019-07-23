package com.example.booksearch.domain.user.service;

import com.example.booksearch.domain.user.entity.UserSearchHistory;
import com.example.booksearch.domain.user.repository.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSearchHistoryServiceImpl implements UserSearchHistoryService {

    @Autowired
    private UserSearchRepository userSearchRepository;

    @Override
    public UserSearchHistory save(String userId, String keyword) {
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(keyword)) {
            throw new IllegalArgumentException("필수값이 비었습니다.");
        }

        return userSearchRepository.save(new UserSearchHistory(userId, keyword));
    }

    @Override
    public List<UserSearchHistory> findSearchHistory(String userId) {
        if(StringUtils.isEmpty(userId)) {
            return new ArrayList<>();
        }

        return userSearchRepository.findByUserIdOrderByIdDesc(userId);
    }
}

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
    public boolean save(String userId, String keyword) {
        userSearchRepository.save(new UserSearchHistory(userId, keyword));
        return true;
    }

    @Override
    public List<UserSearchHistory> findSearchHistory(String userId) {
        if(StringUtils.isEmpty(userId)) {
            return new ArrayList<>();
        }

        return userSearchRepository.findByUserIdOrderByIdDesc(userId);
    }
}

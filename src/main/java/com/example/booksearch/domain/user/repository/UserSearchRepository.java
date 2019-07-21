package com.example.booksearch.domain.user.repository;

import com.example.booksearch.domain.user.entity.UserSearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSearchRepository extends JpaRepository<UserSearchHistory, Long> {

    List<UserSearchHistory> findByUserIdOrderByIdDesc(String userId);
}

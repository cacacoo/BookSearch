package com.example.booksearch.domain.keyword.repository;

import com.example.booksearch.domain.keyword.entity.KeywordCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordCountRepository extends JpaRepository<KeywordCount, Long> {
    List<KeywordCount> findTop10ByOrderBySearchCountDesc();

    KeywordCount findByKeyword(String keyword);
}

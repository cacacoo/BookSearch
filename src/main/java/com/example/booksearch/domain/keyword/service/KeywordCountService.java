package com.example.booksearch.domain.keyword.service;

import com.example.booksearch.domain.keyword.entity.KeywordCount;

import java.util.List;

public interface KeywordCountService {
    List<KeywordCount> getTopKeywordCount();

    KeywordCount recordKeywordCount(String keyword);
}

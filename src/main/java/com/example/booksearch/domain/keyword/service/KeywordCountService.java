package com.example.booksearch.domain.keyword.service;

import com.example.booksearch.domain.keyword.dto.KeywordCount;
import com.example.booksearch.domain.keyword.entity.Keyword;

import java.util.List;

public interface KeywordCountService {
    List<KeywordCount> getTopKeywordCount();

    Keyword recordKeyword(String keyword);
}

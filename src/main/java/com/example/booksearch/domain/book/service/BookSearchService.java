package com.example.booksearch.domain.book.service;

import com.example.booksearch.domain.book.dto.SearchCondition;
import com.example.booksearch.domain.book.dto.SearchResult;

public interface BookSearchService {
    SearchResult findByCondition(SearchCondition condition);
}

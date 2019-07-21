package com.example.booksearch.domain.book.repository;

import com.example.booksearch.domain.book.dto.SearchCondition;
import com.example.booksearch.domain.book.dto.SearchResult;

public interface BookSearchRepository {
    SearchResult findByCondition(SearchCondition condition);
}

package com.example.booksearch.domain.book.service;

import com.example.booksearch.domain.book.dto.SearchCondition;
import com.example.booksearch.domain.book.dto.SearchResult;
import com.example.booksearch.domain.book.repository.BookSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BookSearchServiceImpl implements BookSearchService {

    @Autowired
    private BookSearchRepository bookSearchRepository;

    @Override
    public SearchResult findByKeyword(String keyword) {
        if (StringUtils.isEmpty(keyword)) {
            return null;
        }

        SearchCondition condition = new SearchCondition();
        condition.setQuery(keyword);
        return this.findByCondition(condition);
    }

    @Override
    public SearchResult findByCondition(SearchCondition condition) {
        if (condition == null || StringUtils.isEmpty(condition.getQuery())) {
            return null;
        }

        return bookSearchRepository.findByCondition(condition);
    }
}

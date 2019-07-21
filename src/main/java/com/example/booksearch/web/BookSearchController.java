package com.example.booksearch.web;

import com.example.booksearch.domain.book.dto.SearchCondition;
import com.example.booksearch.domain.book.dto.SearchResult;
import com.example.booksearch.domain.book.service.BookSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookSearchController {

    @Autowired
    private BookSearchService bookSearchService;

    @PostMapping("/book/search")
    public SearchResult searchBook(@RequestBody SearchCondition condition) {
        return bookSearchService.findByCondition(condition);
    }

}

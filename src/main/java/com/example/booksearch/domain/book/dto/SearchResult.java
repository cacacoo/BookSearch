package com.example.booksearch.domain.book.dto;

import com.example.booksearch.domain.book.vo.Book;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SearchResult {
    private Meta meta;
    private List<Book> documents;
}

package com.example.booksearch.domain.book.dto;

import com.example.booksearch.domain.book.constants.SortType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCondition {
    private String query;
    private SortType sort = SortType.ACCURACY;
    private Integer page = 10;
    private Integer size = 1;
}

package com.example.booksearch.domain.book.constants;

import lombok.Getter;

@Getter
public enum SortType {

    ACCURACY("accuracy"),
    RECENCY("recency");

    private String value;

    SortType(String value) {
        this.value = value;
    }
}

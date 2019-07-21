package com.example.booksearch.domain.book.constants;

import lombok.Getter;

@Getter
public enum SortType {

    ACCURACY("accuracy", "정확도"),
    RECENCY("recency","최신순");

    private String value;
    private String name;

    SortType(String value, String name) {
        this.value = value;
        this.name = name;
    }
}

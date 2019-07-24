package com.example.booksearch.domain.keyword.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Keyword {

    @Id
    @GeneratedValue
    private Long id;

    private String keyword;

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

}

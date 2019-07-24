package com.example.booksearch.domain.keyword.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Getter
@Builder
public class KeywordCount {
    private String keyword;
    private BigInteger searchCount;
}

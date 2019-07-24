package com.example.booksearch.domain.keyword.service;

import com.example.booksearch.domain.keyword.dto.KeywordCount;
import com.example.booksearch.domain.keyword.entity.Keyword;
import com.example.booksearch.domain.keyword.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeywordCountServiceImpl implements KeywordCountService {

    @Autowired
    private KeywordRepository keywordRepository;

    private static final String TOP_KEYWORD = "topkeyword";

    @Override
    @Cacheable(TOP_KEYWORD)
    public List<KeywordCount> getTopKeywordCount() {
        List<Object[]> resultList = keywordRepository.findTop10Keyword();
        return resultList.stream().map(result -> KeywordCount.builder()
            .keyword((String) result[0])
            .searchCount((BigInteger) result[1])
            .build()).collect(Collectors.toList());
    }

    public Keyword recordKeyword(String keyword) {
        if (keyword == null) {
            throw new IllegalArgumentException("keyword 값은 필수값입니다.");
        }
        return keywordRepository.save(new Keyword(keyword));
    }

}

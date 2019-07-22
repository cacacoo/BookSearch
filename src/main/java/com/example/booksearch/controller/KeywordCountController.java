package com.example.booksearch.controller;

import com.example.booksearch.domain.keyword.entity.KeywordCount;
import com.example.booksearch.domain.keyword.service.KeywordCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KeywordCountController {

    @Autowired
    private KeywordCountService keywordCountService;

    @GetMapping("/keyword/count")
    public List<KeywordCount> getTopKeywordCount() {
        return keywordCountService.getTopKeywordCount();
    }

    @PutMapping("/keyword/count")
    public KeywordCount recordKeywordCount(@RequestParam String keyword) {
        return keywordCountService.recordKeywordCount(keyword);
    }

}

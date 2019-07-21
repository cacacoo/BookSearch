package com.example.booksearch.domain.book.repository;

import com.example.booksearch.domain.book.dto.SearchCondition;
import com.example.booksearch.domain.book.dto.SearchResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class BookSearchRepositoryImpl implements BookSearchRepository {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public SearchResult findByCondition(SearchCondition condition) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "KakaoAK 78651b99868fe4502d0f7b0382876d47");

        String apiUrl = "https://dapi.kakao.com/v3/search/book";
        String requestUrl = apiUrl
            .concat("?query=").concat(condition.getQuery())
            .concat("&sort=").concat(condition.getSort().getValue())
            .concat("&page=").concat(condition.getPage().toString())
            .concat("&size=").concat(condition.getSize().toString());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        String json =
            restTemplate.exchange(requestUrl, HttpMethod.GET, entity, String.class).getBody();

        return new Gson().fromJson(json, SearchResult.class);
    }
}

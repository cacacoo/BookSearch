package com.example.booksearch.domain.book.repository;

import com.example.booksearch.domain.book.dto.SearchCondition;
import com.example.booksearch.domain.book.dto.SearchResult;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Slf4j
@Component
public class KakaoBookSearchRepository implements BookSearchRepository {

    @Autowired
    private RestTemplate restTemplate;

    private final String apiAuthKey;
    private final String apiUrl;

    public KakaoBookSearchRepository(
        @Value("${kakao.api.auth}") String apiAuthKey,
        @Value("${kakao.api.url}") String apiUrl
    ) {
        this.apiAuthKey = apiAuthKey;
        this.apiUrl = apiUrl;
    }

    @Override
    public SearchResult findByCondition(SearchCondition condition) {
        try {
            String json = restTemplate.exchange(
                buildRequestUrl(condition),
                HttpMethod.GET,
                buildHttpEntity(),
                String.class).getBody();

            return new Gson().fromJson(json, SearchResult.class);
        } catch (Exception ex) {
            log.error("{}", ex);
            return null;
        }
    }

    private String buildRequestUrl(SearchCondition condition) {
        return apiUrl
            .concat("?query=").concat(condition.getQuery())
            .concat("&sort=").concat(condition.getSort().getValue())
            .concat("&page=").concat(condition.getPage().toString())
            .concat("&size=").concat(condition.getSize().toString());
    }

    private HttpEntity<String> buildHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiAuthKey);
        return new HttpEntity<>(headers);
    }
}

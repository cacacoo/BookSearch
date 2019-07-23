package com.example.booksearch.domain.book.repository;

import com.example.booksearch.domain.book.dto.SearchCondition;
import com.example.booksearch.domain.book.dto.SearchResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

@RunWith(MockitoJUnitRunner.class)
public class KakaoBookSearchRepositoryTest {

    @InjectMocks
    private KakaoBookSearchRepository bookSearchRepository;

    @Before
    public void setUp() {
        bookSearchRepository = new KakaoBookSearchRepository("authkey", "testUrl");
    }

    @Test
    public void findByCondition_exception_발생() {
        SearchCondition condition = new SearchCondition();
        condition.setQuery("query");

        // when
        SearchResult result = bookSearchRepository.findByCondition(condition);

        // then
        assertThat(result, nullValue());
    }

}
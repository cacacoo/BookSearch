package com.example.booksearch.domain.book.service;

import com.example.booksearch.domain.book.dto.SearchCondition;
import com.example.booksearch.domain.book.dto.SearchResult;
import com.example.booksearch.domain.book.repository.BookSearchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookSearchServiceImplTest {

    @InjectMocks
    private BookSearchServiceImpl bookSearchService;

    @Mock
    private BookSearchRepository bookSearchRepository;

    @Test
    public void findByCondition_잘못된_파람() {
        SearchResult result = bookSearchService.findByCondition(null);
        assertThat(result, nullValue());

        SearchResult result2 = bookSearchService.findByCondition(new SearchCondition());
        assertThat(result2, nullValue());
    }

    @Test
    public void findByCondition() {
        SearchCondition condition = new SearchCondition();
        condition.setQuery("test");
        SearchResult mockResult = SearchResult.builder().build();

        when(bookSearchRepository.findByCondition(condition)).thenReturn(mockResult);

        SearchResult result = bookSearchService.findByCondition(condition);

        assertThat(result, is(mockResult));
    }
}
package com.example.booksearch.domain.keyword.service;

import com.example.booksearch.domain.keyword.dto.KeywordCount;
import com.example.booksearch.domain.keyword.entity.Keyword;
import com.example.booksearch.domain.keyword.repository.KeywordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KeywordCountServiceImplTest {

    @InjectMocks
    private KeywordCountServiceImpl keywordCountService;

    @Mock
    private KeywordRepository keywordRepository;

    @Test
    public void getTopKeywordCount() {
        Object[] mockResult = new Object[2];
        mockResult[0] = "test";
        mockResult[1] = BigInteger.ONE;
        List<Object[]> resultList = new ArrayList<>();
        resultList.add(mockResult);

        when(keywordRepository.findTop10Keyword()).thenReturn(resultList);

        List<KeywordCount> result = keywordCountService.getTopKeywordCount();

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getKeyword(), is("test"));
        assertThat(result.get(0).getSearchCount().intValue(), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void recordKeyword_잘못된_파람() {
        keywordCountService.recordKeyword(null);
    }

    @Test()
    public void recordKeyword() {
        String keyword = "test";
        Keyword mock = new Keyword(keyword);

        when(keywordRepository.save(mock)).thenReturn(mock);

        Keyword result = keywordCountService.recordKeyword(keyword);

        assertThat(result, is(mock));
    }
}
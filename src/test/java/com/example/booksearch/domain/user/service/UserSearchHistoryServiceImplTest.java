package com.example.booksearch.domain.user.service;

import com.example.booksearch.domain.user.entity.UserSearchHistory;
import com.example.booksearch.domain.user.repository.UserSearchRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserSearchHistoryServiceImplTest {

    @InjectMocks
    private UserSearchHistoryServiceImpl userSearchHistoryService;

    @Mock
    private UserSearchRepository userSearchRepository;

    @Test(expected = IllegalArgumentException.class)
    public void save_잘못된_파람() {
        userSearchHistoryService.save(null, "test");
    }

    @Test()
    public void save() {
        UserSearchHistory mockResult = new UserSearchHistory();
        when(userSearchRepository.save(any(UserSearchHistory.class))).thenReturn(mockResult);

        UserSearchHistory result = userSearchHistoryService.save("test", "test");

        assertThat(result, is(mockResult));
    }

    @Test
    public void findSearchHistory_잘못된_파람() {
        List<UserSearchHistory> result = userSearchHistoryService.findSearchHistory(null);

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void findSearchHistory() {
        String userId = "test";
        List<UserSearchHistory> mockResult = Lists.newArrayList(new UserSearchHistory());
        when(userSearchRepository.findByUserIdOrderByIdDesc(userId)).thenReturn(mockResult);

        List<UserSearchHistory> result = userSearchHistoryService.findSearchHistory(userId);

        assertThat(result, is(mockResult));
    }
}
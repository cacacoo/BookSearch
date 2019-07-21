package com.example.booksearch;

import com.example.booksearch.domain.keyword.entity.KeywordCount;
import com.example.booksearch.domain.keyword.repository.KeywordCountRepository;
import com.example.booksearch.domain.user.entity.User;
import com.example.booksearch.domain.user.entity.UserSearchHistory;
import com.example.booksearch.domain.user.repository.UserRepository;
import com.example.booksearch.domain.user.repository.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksearchApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSearchRepository userSearchRepository;

    @Autowired
    private KeywordCountRepository keywordCountRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("cacacoo", "test"));
        userSearchRepository.save(new UserSearchHistory("cacacoo", "yes"));

        keywordCountRepository.save(new KeywordCount("test", 4L));
        keywordCountRepository.save(new KeywordCount("tt", 2L));
        keywordCountRepository.save(new KeywordCount("tst", 8L));
        keywordCountRepository.save(new KeywordCount("ttt", 1L));
    }

    public static void main(String[] args) {
        SpringApplication.run(BooksearchApplication.class, args);
    }

}

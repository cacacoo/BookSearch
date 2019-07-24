package com.example.booksearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BooksearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BooksearchApplication.class, args);
    }
}

package com.example.booksearch.domain.keyword.repository;

import com.example.booksearch.domain.keyword.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    @Query(value = "SELECT k.keyword, COUNT(k.keyword) FROM Keyword k " +
        "GROUP BY k.keyword " +
        "ORDER By COUNT(k.keyword) DESC " +
        "LIMIT 10 ",
        nativeQuery = true)
    List<Object[]> findTop10Keyword();
}

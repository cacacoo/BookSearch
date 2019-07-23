package com.example.booksearch.domain.keyword.service;

import com.example.booksearch.domain.keyword.entity.KeywordCount;
import com.example.booksearch.domain.keyword.repository.KeywordCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class KeywordCountServiceImpl implements KeywordCountService {

    @Autowired
    private KeywordCountRepository keywordCountRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<KeywordCount> getTopKeywordCount() {
        return keywordCountRepository.findTop10ByOrderBySearchCountDesc();
    }

    @Override
    @Transactional
    public KeywordCount recordKeywordCount(String keyword) {
        if (keyword == null) {
            throw new IllegalArgumentException("keyword 값은 필수값입니다.");
        }

        TypedQuery<KeywordCount> typedQuery = entityManager.createQuery(
            "select kc from KeywordCount kc where kc.keyword = :keyword", KeywordCount.class);
        typedQuery.setLockMode(LockModeType.PESSIMISTIC_WRITE);

        KeywordCount keywordCount =
            typedQuery.setParameter("keyword", keyword).getResultStream().findFirst().orElse(null);
        if (keywordCount != null) {
            keywordCount.setSearchCount(keywordCount.getSearchCount() + 1);
            return keywordCount;
        }

        return keywordCountRepository.save(new KeywordCount(keyword, 1L));
    }

}

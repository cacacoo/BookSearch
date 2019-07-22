package com.example.booksearch.domain.user.dto;

import com.example.booksearch.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCheckDto {
    private boolean success;
    private User user;
    private String message;
}

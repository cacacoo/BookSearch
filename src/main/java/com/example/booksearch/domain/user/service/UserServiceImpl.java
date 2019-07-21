package com.example.booksearch.domain.user.service;

import com.example.booksearch.common.EncryptionUtil;
import com.example.booksearch.domain.user.entity.User;
import com.example.booksearch.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User signUp(String userId, String pwd) {
        if(userId == null || pwd == null) {
            throw new IllegalArgumentException("필수정보가 누락되었습니다");
        }

        User existUser = userRepository.findByUserId(userId);
        if(existUser != null) {
            throw new IllegalArgumentException("이미 존재하는 userId 입니다");
        }

        String encryptPwd= EncryptionUtil.encryptSHA256(pwd);
        if(encryptPwd == null) {
            throw new IllegalArgumentException("pwd 암호화에 실패했습니다");
        }

        return userRepository.save(new User(userId, encryptPwd));
    }
}

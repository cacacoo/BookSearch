package com.example.booksearch.domain.user.service;

import com.example.booksearch.common.EncryptionUtil;
import com.example.booksearch.domain.user.dto.UserCheckDto;
import com.example.booksearch.domain.user.entity.User;
import com.example.booksearch.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserCheckDto signUp(String userId, String pwd) {
        if(userId == null || pwd == null) {
            return UserCheckDto.builder()
                .success(false)
                .message("필수정보가 누락되었습니다")
                .build();
        }

        User existUser = userRepository.findByUserId(userId);
        if(existUser != null) {
            return UserCheckDto.builder()
                .success(false)
                .message("이미 존재하는 userId 입니다")
                .build();
        }

        String encryptPwd= EncryptionUtil.encryptSHA256(pwd);
        User user= userRepository.save(new User(userId, encryptPwd));
        return UserCheckDto.builder()
            .success(true)
            .message("가입 성공. 로그인해주세요")
            .user(user)
            .build();
    }

    @Override
    public UserCheckDto checkLogin(String userId, String pwd) {
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(pwd)) {
            return UserCheckDto.builder()
                .success(false)
                .message("필수정보가 누락되었습니다")
                .build();
        }

        User user = userRepository.findByUserId(userId);
        if(user == null) {
            return UserCheckDto.builder()
                .success(false)
                .message("고객을 찾을 수 없습니다")
                .build();
        }

        String encryptPwd= EncryptionUtil.encryptSHA256(pwd);
        if(!user.getPwd().equals(encryptPwd)) {
            return UserCheckDto.builder()
                .success(false)
                .message("비밀번호가 틀렸습니다")
                .build();
        }

        return UserCheckDto.builder()
            .success(true)
            .user(user)
            .build();
    }
}

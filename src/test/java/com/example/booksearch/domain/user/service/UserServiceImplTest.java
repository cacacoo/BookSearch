package com.example.booksearch.domain.user.service;

import com.example.booksearch.common.EncryptionUtil;
import com.example.booksearch.domain.user.dto.UserCheckDto;
import com.example.booksearch.domain.user.entity.User;
import com.example.booksearch.domain.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void signUp_필수정보_누락() {
        // when
        UserCheckDto result  = userService.signUp(null, "test");

        // then
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), is("필수정보가 누락되었습니다"));
    }

    @Test
    public void signUp_이미_존재하는_고객() {
        String userId = "test";
        String pwd = "pwd";

        // given
        when(userRepository.findByUserId(userId)).thenReturn(new User());

        // when
        UserCheckDto result  = userService.signUp(userId, pwd);

        // then
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), is("이미 존재하는 userId 입니다"));
    }

    @Test
    public void signUp_성공() {
        String userId = "test";
        String pwd = "pwd";
        String encryptPwd = EncryptionUtil.encryptSHA256(pwd);
        User mockUser = new User(userId, encryptPwd);

        // given
        when(userRepository.findByUserId(userId)).thenReturn(null);
        when(userRepository.save(any(User.class))).thenReturn(mockUser);

        // when
        UserCheckDto result  = userService.signUp(userId, pwd);

        // then
        assertThat(result.isSuccess(), is(true));
        assertThat(result.getUser().getUserId(), is(userId));
        assertThat(result.getUser().getPwd(), is(encryptPwd));
    }

    @Test
    public void checkLogin_필수정보_누락() {
        // when
        UserCheckDto result  = userService.checkLogin("test", null);

        // then
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), is("필수정보가 누락되었습니다"));
    }

    @Test
    public void checkLogin_고객_못찾음() {
        String userId = "test";
        String pwd = "pwd";

        // given
        when(userRepository.findByUserId(userId)).thenReturn(null);

        // when
        UserCheckDto result  = userService.checkLogin(userId, pwd);

        // then
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), is("고객을 찾을 수 없습니다"));
    }

    @Test
    public void checkLogin_비밀번호_틀림() {
        String userId = "test";
        String pwd = "pwd";
        String encryptPwd = EncryptionUtil.encryptSHA256("diffPwd");
        User mockUser = new User(userId, encryptPwd);

        // given
        when(userRepository.findByUserId(userId)).thenReturn(mockUser);

        // when
        UserCheckDto result  = userService.checkLogin(userId, pwd);

        // then
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), is("비밀번호가 틀렸습니다"));
    }

    @Test
    public void checkLogin_성공() {
        String userId = "test";
        String pwd = "pwd";
        String encryptPwd = EncryptionUtil.encryptSHA256(pwd);
        User mockUser = new User(userId, encryptPwd);

        // given
        when(userRepository.findByUserId(userId)).thenReturn(mockUser);

        // when
        UserCheckDto result  = userService.checkLogin(userId, pwd);

        // then
        assertThat(result.isSuccess(), is(true));
        assertThat(result.getUser().getUserId(), is(userId));
        assertThat(result.getUser().getPwd(), is(encryptPwd));
    }
}
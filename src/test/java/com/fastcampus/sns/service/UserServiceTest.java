package com.fastcampus.sns.service;

import com.fastcampus.sns.exception.SnsApplicationException;
import com.fastcampus.sns.model.entity.UserEntity;
import com.fastcampus.sns.repository.UserEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    private final UserService userService;

    @MockBean
    private UserEntityRepository userEntityRepository;

    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void 회원가입이_정상적으로_동작하는_경우() {

        String userName = "userName";
        String password = "userName";

        // mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.empty());
        when(userEntityRepository.save(any())).thenReturn(Optional.of(mock(UserEntity.class)));


        Assertions.assertDoesNotThrow(() -> userService.join(userName,password));
    }

    @Test
    public void 회원가입시_userName이_이미_존재하는_경우() {

        String userName = "userName";
        String password = "userName";

        // mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(mock(UserEntity.class)));
        when(userEntityRepository.save(any())).thenReturn(Optional.of(mock(UserEntity.class)));

        Assertions.assertThrows(SnsApplicationException.class, () -> userService.join(userName,password));
    }

    @Test
    public void 로그인이_정상적으로_동작하는_경우() {

        String userName = "userName";
        String password = "userName";

        // mocking

        Assertions.assertDoesNotThrow(() -> userService.login(userName,password));
    }

    @Test
    public void 로그인시_아이디가_틀린경우() {

        String userName = "userName";
        String password = "userName";

        // mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(mock(UserEntity.class)));
        when(userEntityRepository.save(any())).thenReturn(Optional.of(mock(UserEntity.class)));

        Assertions.assertThrows(SnsApplicationException.class, () -> userService.join(userName,password));
    }
}

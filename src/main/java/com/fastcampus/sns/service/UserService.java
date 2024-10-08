package com.fastcampus.sns.service;

import com.fastcampus.sns.exception.SnsApplicationException;
import com.fastcampus.sns.model.User;
import com.fastcampus.sns.model.entity.UserEntity;
import com.fastcampus.sns.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserEntityRepository userEntityRepository;

    public UserService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    // TODO implement
    public User join(String userName, String password) {

        // 회원가입 전 userName 존재하는지 검사
        Optional<UserEntity> userEntity = userEntityRepository.findByUserName(userName);

        // 회원가입 진행 = user 등록
        userEntityRepository.save(new UserEntity());

        return new User();
    }

    // TODO Secure login
    public String login(String userName, String password) {

        // 회원가입 여부 체크
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException());

        // 비밀번호 체크
        if(!userEntity.getPassword().equals(password)) {
            throw new SnsApplicationException();
        }

        // 토큰 생성

        return "";
    }
}

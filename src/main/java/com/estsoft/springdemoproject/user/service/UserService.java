package com.estsoft.springdemoproject.user.service;

import com.estsoft.springdemoproject.user.domain.User;
import com.estsoft.springdemoproject.user.domain.dto.AddUserRequest;
import com.estsoft.springdemoproject.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User save(AddUserRequest dto) {
        return userRepository.save(
                User.builder()
                        .email(dto.getEmail())
                        .password(encoder.encode(dto.getPassword()))    // 패스워드 암호화
                        .build()
        );
    }
}
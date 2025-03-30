package com.springblog.springblog.service;

import com.springblog.springblog.dto.UserDto;
import com.springblog.springblog.domain.User;
import com.springblog.springblog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new RuntimeException("이미 사용 중인 사용자 이름입니다.");
        }

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        User user = new User(userDto.getUsername(), encodedPassword, userDto.getEmail());

        userRepository.save(user);
    }
}

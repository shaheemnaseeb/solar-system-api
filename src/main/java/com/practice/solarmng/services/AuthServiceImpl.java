package com.practice.solarmng.services;

import com.practice.solarmng.entity.UserEntity;
import com.practice.solarmng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;

    @Autowired
    //private PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public boolean checkUserCredentials(String username, String password) {
//        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
//        if (userOptional.isEmpty()) {
//            return false;
//        }
//
//        UserEntity user = userOptional.get();
//
//        return passwordEncoder.matches(password, user.getPassword());
//    }
}
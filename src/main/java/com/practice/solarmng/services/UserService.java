package com.practice.solarmng.services;

import com.practice.solarmng.model.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);

    User getUser(String username);

    User updateUser(String username, User user);

    void deleteUser(String username);

    User loginUser(User username);

    //void updatePassword(long userId, String newPassword);
}

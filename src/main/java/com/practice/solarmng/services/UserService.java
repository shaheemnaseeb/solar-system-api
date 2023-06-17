package com.practice.solarmng.services;

import com.practice.solarmng.model.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);

    User getUser(long id);

    User updateUser(long id, User user);

    void deleteUser(long id);

    User loginUser(User username);

    //void updatePassword(long userId, String newPassword);
}

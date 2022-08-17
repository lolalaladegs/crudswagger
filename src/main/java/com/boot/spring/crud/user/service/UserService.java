package com.boot.spring.crud.user.service;

import com.boot.spring.crud.user.dto.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();

    UserEntity getUserById(int id);

    void addUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(int id);
}

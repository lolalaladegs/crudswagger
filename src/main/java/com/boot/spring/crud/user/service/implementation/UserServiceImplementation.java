package com.boot.spring.crud.user.service.implementation;

import com.boot.spring.crud.user.dto.UserEntity;
import com.boot.spring.crud.user.repository.UserRepository;
import com.boot.spring.crud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public UserEntity getUserById(int id) {
        UserEntity user = userRepository.getUserById(id);
        return user;
    }

    @Override
    public void addUser(UserEntity user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}

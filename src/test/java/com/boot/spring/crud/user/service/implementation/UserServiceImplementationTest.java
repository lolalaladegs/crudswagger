package com.boot.spring.crud.user.service.implementation;

import com.boot.spring.crud.user.dto.UserEntity;
import com.boot.spring.crud.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class UserServiceImplementationTest {
    @InjectMocks
    private UserServiceImplementation userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void getAllUsers(){
        //given
        List<UserEntity> userList = new ArrayList<>();
        userList.add(new UserEntity());

        given(userRepository.findAll()).willReturn(userList);

        //when
        userService.getAllUsers();

        //then
        then(userRepository).should().findAll();
    }

    @Test
    void getUserById(){
        //given
        int id = 1;
        UserEntity user = new UserEntity();

        given(userRepository.getUserById(id)).willReturn(user);

        //when
        userService.getUserById(id);

        //then
        then(userRepository).should().getUserById(id);
    }

    @Test
    void addUser(){
        //given
        UserEntity user = new UserEntity();
        given(userRepository.saveAndFlush(user)).willReturn(user);

        //when
        userService.addUser(user);

        //then
        then(userRepository).should().saveAndFlush(user);
    }

    @Test
    void updateUser(){
        //given
        UserEntity user = new UserEntity();
        given(userRepository.saveAndFlush(user)).willReturn(user);

        //when
        userService.updateUser(user);

        //then
        then(userRepository).should().saveAndFlush(user);
    }

    @Test
    void deleteUser(){
        //given
        int id = 1;
        UserEntity user = new UserEntity();

        willDoNothing().given(userRepository).deleteById(id);

        //when
        userService.deleteUser(id);

        //then
        then(userRepository).should().deleteById(id);
    }
}

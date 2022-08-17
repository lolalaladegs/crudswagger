package com.boot.spring.crud.user.controller;

import com.boot.spring.crud.user.dto.UserEntity;
import com.boot.spring.crud.user.model.MessageResponse;
import com.boot.spring.crud.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import static com.boot.spring.crud.user.constant.UserConstant.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserEntity>> getAllUser(){
        try{
            List<UserEntity> userList = userService.getAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(userList);
        }catch (CannotCreateTransactionException transactionException){
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.emptyList());
        }
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id){
        UserEntity user = new UserEntity();
        try{
            user = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }catch (CannotCreateTransactionException transactionException){
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(user);
        }catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(user);
        }
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> addUser(@RequestBody UserEntity user){
        try{
            userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse(SUCCESSFULLY_CREATE_USER + user.getName()));
        }catch (CannotCreateTransactionException transactionException){
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse(CANNOT_CREATE_USER_INTERNAL_SERVER_ERROR));
        }catch (Exception exception){
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(CANNOT_CREATE_USER));
        }
    }

    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> updateUser(@RequestBody UserEntity user){
        try{
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(SUCCESSFULLY_UPDATE_USER + user.getName()));
        }catch (CannotCreateTransactionException transactionException){
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse(CANNOT_UPDATE_USER_INTERNAL_SERVER_ERROR));
        }catch (Exception exception){
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(CANNOT_UPDATE_USER));
        }
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable int id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(SUCCESSFULLY_DELETE_USER));
        }catch (CannotCreateTransactionException transactionException){
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse(CANNOT_DELETE_USER_INTERNAL_SERVER_ERROR));
        }catch (Exception exception){
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(CANNOT_DELETE_USER));
        }
    }

}

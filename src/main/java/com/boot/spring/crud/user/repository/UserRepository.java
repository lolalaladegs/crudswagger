package com.boot.spring.crud.user.repository;

import com.boot.spring.crud.user.dto.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(name = "User.getUserById", nativeQuery = true)
    UserEntity getUserById(@Param("id") int id);
}
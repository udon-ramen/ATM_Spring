package com.example.demo.Login.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.Login.entity.MyUser;

@Repository
public interface UserDao {
    MyUser findUserByUserName(String userName);
}

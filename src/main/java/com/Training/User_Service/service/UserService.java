package com.Training.User_Service.service;

import com.Training.User_Service.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(Long id,User user);

    List<User> getAllUsers();

    User getUser(Long id);

    void deleteUser(Long id);

}

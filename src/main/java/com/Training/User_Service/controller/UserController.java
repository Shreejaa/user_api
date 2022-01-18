package com.Training.User_Service.controller;

import com.Training.User_Service.entity.User;
import com.Training.User_Service.exception.UserNotFoundException;
import com.Training.User_Service.serviceImpl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/users")
@RestController
@RefreshScope
@Api(value = "This is a User Profile management system. We can use below defined API's to create, delete, update and view User's Profile")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping()
    @ApiOperation(value = "View all the User Profiles present",response = User.class)
    public ResponseEntity<List<User>> getAll(){
        log.info("get all user(user service)");
        List<User> list=userService.getAllUsers();
        return  new ResponseEntity<List<User>>(list,new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "View a user profile based on ID", response = User.class)
    public ResponseEntity<User> getUserById(
            @ApiParam(value = "UserID to find a User Profile",required = true)
            @PathVariable(name = "id") Long id) throws UserNotFoundException {
        log.info("get user by id(user service)");
        User userEntity = userService.getUser(id);
        return  new ResponseEntity<User>(userEntity,new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/username/{username}")
    @ApiOperation(value = "View a user profile based on username", response = User.class)
    public ResponseEntity<User> getuserByUsername(@PathVariable(name = "username") String username){
        User user=userService.findByusername(username);
        return new ResponseEntity<>(user,new HttpHeaders(),HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new user profile ", response = User.class)
    public ResponseEntity<User> saveUser(@RequestBody User user){
        log.info("save a user (user service)");
        User newUser = userService.createUser(user);
        return new ResponseEntity<User>(newUser,new HttpHeaders(),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update a user profile via ID ", response = User.class)
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        log.info("update user details (user service)");
        User updatedUser = userService.updateUser(id,user);
        return new ResponseEntity<User>(updatedUser, new HttpHeaders(),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a user profile via ID ", response = User.class)
    public HttpStatus deleteBook(
            @ApiParam(value = "UserID to find a User profile",required = true)
            @PathVariable(name = "id") Long id){
        log.info("delete user (user service)");
        userService.deleteUser(id);
        return HttpStatus.OK;

    }



}

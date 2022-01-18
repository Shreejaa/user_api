package com.Training.User_Service.serviceImpl;

import com.Training.User_Service.UserRepository;
import com.Training.User_Service.entity.User;
import com.Training.User_Service.exception.UserNotFoundException;
import com.Training.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @Autowired
    UserRepository userRepository;

    public User findByusername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id,User user) {
        if(id>0){
            User newuser = new User();
            newuser.setUserid(id);
            newuser.setFirstname(user.getFirstname());
            newuser.setLastname(user.getLastname());
            newuser.setPhoneno(user.getPhoneno());
            newuser.setUseremail(user.getUseremail());
            newuser.setUsername(user.getUsername());
            newuser.setPassword(passwordEncoder.encode(user.getPassword()));
            newuser.setRole(user.getRole());
            return  userRepository.saveAndFlush(newuser);
        }else{
            throw new UserNotFoundException("no user exists with id ",id);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        if (users.size() > 0) {
            return users;
        } else {
            return new ArrayList<User>();
        }
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw new UserNotFoundException("No user exists with id ",id);
        }
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
             userRepository.deleteById(id);
        }else{
            throw new UserNotFoundException("No user exists with id ",id);
        }
    }
}

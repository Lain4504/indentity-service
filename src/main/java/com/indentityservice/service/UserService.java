package com.indentityservice.service;

import com.indentityservice.dto.request.UserCreationRequest;
import com.indentityservice.dto.request.UserUpdateRequest;
import com.indentityservice.entity.User;
import com.indentityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(UserCreationRequest request){
        User user = new User();

        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("User existed.");

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getLastname());
        user.setLastname(request.getLastname());
        user.setDoB(request.getDoB());
        return userRepository.save(user);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUser(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User updateUser(String userId, UserUpdateRequest request){
        User user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setFirstname(request.getLastname());
        user.setLastname(request.getLastname());
        user.setDoB(request.getDoB());
        return userRepository.save(user);
    }
    public void deleteUser(String userId){
         userRepository.deleteById(userId);
    }
}

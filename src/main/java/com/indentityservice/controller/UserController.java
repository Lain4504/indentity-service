package com.indentityservice.controller;


import com.indentityservice.dto.request.UserCreationRequest;
import com.indentityservice.dto.request.UserUpdateRequest;
import com.indentityservice.entity.User;
import com.indentityservice.repository.UserRepository;
import com.indentityservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // Khai bao mot lan dung nhieu lan
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUser(request);
    }
    @GetMapping
    List<User> getUsers(){
           return userService.getUsers();
    }
    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userid){
        return userService.getUser(userid);
    }
    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted.";
        //case : du id khong ton tai nhung van hien thi xoa
        // thanh cong de tranh bi do ra id cua nguoi dung
    }
}

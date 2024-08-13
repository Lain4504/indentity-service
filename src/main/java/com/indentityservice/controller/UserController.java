package com.indentityservice.controller;


import com.indentityservice.dto.request.ApiResponse;
import com.indentityservice.dto.request.UserCreationRequest;
import com.indentityservice.dto.request.UserUpdateRequest;
import com.indentityservice.entity.User;
import com.indentityservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // Khai bao mot lan dung nhieu lan
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
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

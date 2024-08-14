package com.indentityservice.service;

import com.indentityservice.dto.request.UserCreationRequest;
import com.indentityservice.dto.request.UserUpdateRequest;
import com.indentityservice.dto.response.UserResponse;
import com.indentityservice.entity.User;
import com.indentityservice.exception.AppException;
import com.indentityservice.exception.ErrorCode;
import com.indentityservice.mapper.UserMapper;
import com.indentityservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
   // @Autowired khong phai best practice
    UserRepository userRepository;

    UserMapper userMapper;
    public User createUser(UserCreationRequest request){

        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUSer(request);
        return userRepository.save(user);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }
    public UserResponse updateUser(String userId, UserUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user,request);
        return userMapper.toUserResponse(userRepository.save(user));
    }
    public void deleteUser(String userId){
         userRepository.deleteById(userId);
    }
}

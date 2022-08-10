package com.example.user_service.controller;

import com.example.user_service.request.UserRequest;
import com.example.user_service.response.UserResponse;
import com.example.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    private UserService userService;


Logger logger=LoggerFactory.getLogger(UserController.class);

    @PostMapping("/create")
    public UserResponse saveUser(@RequestBody UserRequest user){
        logger.info(String.valueOf(user));
        return userService.saveUser(user);
    }
@GetMapping("get/{id}")
public UserResponse getUserWithDepartment(@PathVariable Long id){
    return userService.getUserWithDepartment(id);
}

@PatchMapping ("/update/{id}")
    public UserResponse updateUser(@RequestBody UserRequest userRequest,@PathVariable Long id){
        logger.info(String.valueOf(userRequest));
        return userService.updateUser(userRequest,id);
}

}

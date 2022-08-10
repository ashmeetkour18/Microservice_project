package com.example.user_service.service;

import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.request.UserRequest;
import com.example.user_service.response.UserResponse;
import com.example.user_service.utility.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommonService commonService;

    Logger logger= LoggerFactory.getLogger(UserService.class);

    public UserResponse saveUser(UserRequest user) {
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        userRepository.save(user1);
        UserResponse userResponse = new UserResponse(user1);
        userResponse.setDepartmentResponse(commonService.getDepartmentById(user1.getDepartmentId()));
        return userResponse;

    }

    public UserResponse getUserWithDepartment(Long userId) {
        logger.info("Inside User getUserWithDepartment");
        User user = userRepository.findByUserId(userId);
        UserResponse userResponse = new UserResponse(user);
        userResponse.setDepartmentResponse(commonService.getDepartmentById(user.getDepartmentId()));
        return userResponse;

    }


    public UserResponse updateUser(UserRequest userRequest, Long id) {
        User user = new User(getUserWithDepartment(id));
        Util.copyNonNullProperties(userRequest, user);
        userRepository.save(user);
        UserResponse userResponse=new UserResponse(user);
        userResponse.setDepartmentResponse(commonService.getDepartmentById(user.getDepartmentId()));
        return userResponse;
    }
}

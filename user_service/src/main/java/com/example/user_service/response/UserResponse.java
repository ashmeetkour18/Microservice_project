package com.example.user_service.response;

import com.example.user_service.entity.User;
import com.example.user_service.value_objects.DepartmentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private DepartmentResponse departmentResponse;

    public UserResponse(User user){
        this.userId=user.getUserId();
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
        this.email=user.getEmail();

    }

}

package com.example.user_service.entity;

import com.example.user_service.response.UserResponse;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long userId;
private String firstName;
private String lastName;
private String email;
private Long departmentId;

    public User(UserResponse userResponse) {
       this.userId= userResponse.getUserId();
       this.departmentId=userResponse.getDepartmentResponse().getDepartmentId();
       this.firstName=userResponse.getFirstName();
       this.lastName=userResponse.getLastName();
       this.email=userResponse.getEmail();
    }
}

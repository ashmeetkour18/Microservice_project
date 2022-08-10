package com.example.user_service.value_objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponse {
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}

package com.example.department_service.response;

import com.example.department_service.entity.Department;
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

    public DepartmentResponse(Department department){
        this.departmentId=department.getDepartmentId();
        this.departmentAddress=department.getDepartmentAddress();
        this.departmentCode=department.getDepartmentCode();
        this.departmentName=department.getDepartmentName();
    }
}


package com.example.department_service.controller;

import com.example.department_service.entity.Department;
import com.example.department_service.request.DepartmentRequest;
import com.example.department_service.response.DepartmentResponse;
import com.example.department_service.service.DepartmentService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/department")
@Slf4j
@RefreshScope
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public DepartmentResponse saveDepartment(@RequestBody DepartmentRequest department){
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/get/{id}")
    public DepartmentResponse findByDepartmentId(@PathVariable("id") Long departmentId){
        log.info("Inside findByDepartmentId method of DepartmentController");
        return departmentService.findByDepartmentId(departmentId);
    }
@PatchMapping("/update/{id}")
    public DepartmentResponse updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentRequest departmentRequest){
        return departmentService.updateDepartment(departmentId,departmentRequest);
}
}

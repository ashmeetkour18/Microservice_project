package com.example.user_service.feignClients;

import com.example.user_service.value_objects.DepartmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "API-GATEWAY")
public interface DepartmentFeignClient {

    @GetMapping("/DEPARTMENT-SERVICE/api/department/get/{id}")
    DepartmentResponse findByDepartmentId(@PathVariable("id") Long departmentId);
}

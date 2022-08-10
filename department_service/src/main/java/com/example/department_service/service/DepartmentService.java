package com.example.department_service.service;

import com.example.department_service.entity.Department;
import com.example.department_service.repository.DepartmentRepository;
import com.example.department_service.request.DepartmentRequest;
import com.example.department_service.response.DepartmentResponse;
import com.example.department_service.utility.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;


@Service
@RefreshScope
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;



    Logger logger=LoggerFactory.getLogger(DepartmentService.class);

    public DepartmentResponse saveDepartment(DepartmentRequest department) {
        logger.info("Inside saveDepartment of DepartmentService");
        Department department1=new Department();

        BeanUtils.copyProperties(department,department1);
       departmentRepository.save(department1);
        return new DepartmentResponse(department1);
    }

    public DepartmentResponse findByDepartmentId(Long departmentId) {
        String message="Inside findDepartmentById method of DepartmentService : " ;
        logger.info(message,departmentId);
        Department department = departmentRepository.findById(departmentId).get();
//        rabbitTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,
//               department);
return new DepartmentResponse(department);
    }

    public DepartmentResponse updateDepartment(Long departmentId, DepartmentRequest departmentRequest) {
        Department department=departmentRepository.findById(departmentId).get();
        Util.copyNonNullProperties(departmentRequest,department);
        Department department1 = departmentRepository.save(department);
        return new DepartmentResponse(department1);

    }
}

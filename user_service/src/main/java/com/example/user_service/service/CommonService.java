package com.example.user_service.service;

import com.example.user_service.feignClients.DepartmentFeignClient;
import com.example.user_service.value_objects.DepartmentResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @Autowired
    private DepartmentFeignClient departmentFeignClient;

    Logger logger= LoggerFactory.getLogger(CommonService.class);
    long count=1;
    @CircuitBreaker(name="departmentService",fallbackMethod = "fallbackGetDepartmentById")
    public DepartmentResponse getDepartmentById(Long departmentId){
        logger.info("count ="+count);
        count++;
        return departmentFeignClient.findByDepartmentId(departmentId);
    }

    /**
     * Fallback method must have same signature for which @CircuitBreaker is annotated
     */
    public DepartmentResponse fallbackGetDepartmentById(Long departmentId,Throwable throwable){
        logger.error("Error = "+throwable);
        return new DepartmentResponse();
    }
}

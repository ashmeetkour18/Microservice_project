package com.example.department_service.utility;

import com.example.department_service.entity.Department;
import com.example.department_service.request.DepartmentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

public class Util {
    public static void copyNonNullProperties(DepartmentRequest source, Department destination) {
        BeanUtils.copyProperties(source, destination, getNullPropertyNames(source));
    }

    /**
     * Returns an array of null properties of an object
     *
     * @param source
     * @return
     */
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set emptyNames = new HashSet();
        for (java.beans.PropertyDescriptor pd : pds) {
            //check if value of this property is null then add it to the collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }
}

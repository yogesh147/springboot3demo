package com.springboot.demo;

import com.springboot.demo.Model.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class DepartmentControllerTest {

    @Test
    public void shouldCreateDepartment(){
        Department department = new Department(1L, "AllStore", "India", "123" );
        Assertions.assertFalse(Objects.isNull(department.getDepartmentId()));
        Assertions.assertTrue(Objects.nonNull(department.getDepartmentId()));
        Assertions.assertEquals(department.getDepartmentName(), "AllStore");
    }

}
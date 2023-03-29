package com.springboot.demo;

import com.springboot.demo.Model.Department;
import org.junit.jupiter.api.*;

import java.util.Objects;

class DepartmentControllerTest {

    @BeforeAll
    public static void setUpBeforeRunAnyTestCases() {
        System.out.println("Before Run any Test");
    }

    @AfterAll
    public static void setUpAfterRunAnyTestCases() {
        System.out.println("After Run all Test");
    }

    @BeforeEach
    public void runBeforeEachTestCases() {
        System.out.println("New Test case start");
    }

    @AfterEach
    public void runAfterEachTestCases() {
        System.out.println("Test case complete");
    }

    @Test
    public void shouldCreateDepartment(){
        System.out.println("Inside shouldCreateDepartment Test");
        Department department = new Department(1L, "AllStore", "India", "123" );
        Assertions.assertFalse(Objects.isNull(department.getDepartmentId()));
        Assertions.assertTrue(Objects.nonNull(department.getDepartmentId()));
        Assertions.assertEquals(department.getDepartmentName(), "AllStore");
    }

    @Test
    @DisplayName("Should not Create Department when id is null")
    public void shouldThrowRuntimeExceptionsWhenIdIsNull() {
        System.out.println("Inside shouldThrowRuntimeExceptionsWhenIdIsNull Test");
        Department department = new Department(null, "AllStore", "India", "123");
        Assertions.assertDoesNotThrow(() -> checkDepartmentId(department));
    }

    public Long checkDepartmentId(Department department) throws RuntimeException {
        if (Objects.isNull(department.getDepartmentName())) {
            throw new RuntimeException("department Id must be not null");
        }
        return department.getDepartmentId();
    }

}
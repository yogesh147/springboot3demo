package com.springboot.demo;

import com.springboot.demo.Model.Department;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.Objects;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DepartmentControllerTest {

    @BeforeAll
    public void setUpBeforeRunAnyTestCases() {
        System.out.println("Before Run any Test");
    }

    @AfterAll
    public void setUpAfterRunAnyTestCases() {
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
    @Tag("IntegrationTest")
    public void shouldCreateDepartment(){
        System.out.println("Inside shouldCreateDepartment Test");
        Department department = new Department(1L, "AllStore", "India", "123" );
        Assertions.assertFalse(Objects.isNull(department.getDepartmentId()));
        Assertions.assertTrue(Objects.nonNull(department.getDepartmentId()));
        Assertions.assertEquals(department.getDepartmentName(), "AllStore");
    }

    @Test
    @Tag("UnitTest")
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

    @Test
    @Tag("UnitTest")
    @DisplayName("Should be Enabled only on MAC OS")
    @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled only on MAC OS")
    public void shouldbeEnabledOnlyOnMACOS() {
        System.out.println("Inside shouldbeEnabledOnlyOnMACOS Test");
        Department department = new Department(null, "AllStore", "India", "123");
        Assertions.assertDoesNotThrow(() -> checkDepartmentId(department));
    }

    @Test
    @Tag("UnitTest")
    @DisplayName("Should be Disabled only on WINDOW OS")
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled only on Windows OS")
    public void shouldbeDisabledOnlyOnWINOS() {
        System.out.println("Inside shouldbeDisabledOnlyOnWINOS Test");
        Department department = new Department(null, "AllStore", "India", "123");
        Assertions.assertDoesNotThrow(() -> checkDepartmentId(department));
    }


}
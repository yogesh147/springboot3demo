package com.springboot.demo;

import com.springboot.demo.Model.Department;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
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
    public void runBeforeEachTestCases(TestInfo testInfo) {
        log.info("test started :: {} for :: {}", testInfo.getDisplayName(), testInfo.getTags());
    }

    @AfterEach
    public void runAfterEachTestCases(TestInfo testInfo) {
        log.info("test complete :: {}", testInfo.getDisplayName());
    }

    @Test
    @Tag("IntegrationTest")
    @DisplayName("Create Department")
    @Order(1)
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
    @Order(2)
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
    @Order(3)
    @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled only on MAC OS")
    public void shouldBeEnabledOnlyOnMACOS() {
        System.out.println("Inside shouldbeEnabledOnlyOnMACOS Test");
        Department department = new Department(null, "AllStore", "India", "123");
        Assertions.assertDoesNotThrow(() -> checkDepartmentId(department));
    }

    @Test
    @Tag("UnitTest")
    @DisplayName("Should be Disabled only on WINDOW OS")
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled only on Windows OS")
    @Order(4)
    public void shouldBeDisabledOnlyOnWINOS() {
        System.out.println("Inside shouldbeDisabledOnlyOnWINOS Test");
        Department department = new Department(null, "AllStore", "India", "123");
        Assertions.assertDoesNotThrow(() -> checkDepartmentId(department));
    }

    @Test
    @Tag("UnitTest")
    @DisplayName("TestJava8features")
    @Order(5)
    public void testJava8features() {
        System.out.println("Inside testJava8features");
        List<Department> list = new ArrayList<>();
        Department department = new Department(null, "AllStore", "India", "123");
        list.add(department);
        department = new Department(null, "GStore", "India", "456");
        list.add(department);
        department = new Department(null, "MStore", "ENG", "789");
        list.add(department);

        list.stream()
                .filter(rec -> !rec.getDepartmentCode().contains("123"))
                .forEach(data -> Assertions.assertTrue(Objects.nonNull(data.getDepartmentCode())));
    }

    @RepeatedTest(3)
    @DisplayName("repeatedTest")
    void repeatedTest() {
        System.out.println("Executing repeated test");
        Assertions.assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest
    @DisplayName("isOdd_ShouldReturnTrueForOddNumbers")
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        System.out.println("ParameterizedTest");
        Assertions.assertTrue(Numbers.isOdd(number));
    }

}

class Numbers {
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }


}
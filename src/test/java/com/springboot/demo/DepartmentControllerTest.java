package com.springboot.demo;

import com.springboot.demo.Model.Department;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

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

    @TestFactory
    Iterable<DynamicTest> dynamicTestsWithCollection() {
        return Arrays.asList(
                DynamicTest.dynamicTest("Add test",
                        () -> Assertions.assertEquals(2, Math.addExact(1, 1))),
                DynamicTest.dynamicTest("Multiply Test",
                        () -> Assertions.assertEquals(4, Math.multiplyExact(2, 2))));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {

        // sample input and output
        List<String> inputList = Arrays.asList("www.somedomain.com", "www.anotherdomain.com", "www.yetanotherdomain.com");
        List<String> outputList = Arrays.asList("154.174.10.56", "211.152.104.132", "178.144.120.156");

        // input generator that generates inputs using inputList
        Iterator<String> inputGenerator = inputList.iterator();

        // a display name generator that creates a different name based on the input
        Function<String, String> displayNameGenerator = (input) -> "Resolving: " + input;

        // the test executor, which actually has the logic to execute the test case
        DomainNameResolver resolver = new DomainNameResolver();
        ThrowingConsumer<String> testExecutor = (input) -> {
            int id = inputList.indexOf(input);

            Assertions.assertEquals(outputList.get(id), resolver.resolveDomain(input));
        };
        // combine everything and return a Stream of DynamicTest
        return DynamicTest.stream( inputGenerator, displayNameGenerator, testExecutor);
    }

}

class Numbers {
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}

class DomainNameResolver {
    public String resolveDomain(String input) {
        if (input.equalsIgnoreCase("www.somedomain.com")) return "154.174.10.56";
        if (input.equalsIgnoreCase("www.anotherdomain.com")) return "211.152.104.132";
        if (input.equalsIgnoreCase("www.yetanotherdomain.com")) return "178.144.120.156";
        return input;
    }
}

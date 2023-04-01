package com.springboot.demo.mocky.EmployeeTest;

import java.util.List;
import java.util.Optional;

public interface EmployeeTestService {
    EmployeeTest saveEmployeeTest(EmployeeTest employeeTest);

    List<EmployeeTest> getAllEmployeesTest();

    Optional<EmployeeTest> getEmployeeTestById(long id);

    EmployeeTest updateEmployeeTest(EmployeeTest updatedEmployeeTest);

    void deleteEmployeeTest(long id);
}
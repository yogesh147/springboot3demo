package com.springboot.demo.mocky.EmployeeTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeTestController {

    private final EmployeeTestService employeeTestService;

    public EmployeeTestController(EmployeeTestService employeeTestService) {
        this.employeeTestService = employeeTestService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeTest createEmployee(@RequestBody EmployeeTest employeeTest) {
        return employeeTestService.saveEmployeeTest(employeeTest);
    }

    @GetMapping
    public List<EmployeeTest> getAllEmployees() {
        return employeeTestService.getAllEmployeesTest();
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeTest> getEmployeeById(@PathVariable("id") long employeeId) {
        return employeeTestService.getEmployeeTestById(employeeId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeTest> updateEmployee(@PathVariable("id") long employeeId, @RequestBody EmployeeTest employeeTest) {
        return employeeTestService.getEmployeeTestById(employeeId).map(savedEmployee -> {

            savedEmployee.setFirstName(employeeTest.getFirstName());
            savedEmployee.setLastName(employeeTest.getLastName());
            savedEmployee.setEmail(employeeTest.getEmail());

            EmployeeTest updatedEmployee = employeeTestService.updateEmployeeTest(savedEmployee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);

        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeTest(@PathVariable("id") long employeeId) {
        employeeTestService.deleteEmployeeTest(employeeId);
        return new ResponseEntity<String>("EmployeeTest deleted successfully!.", HttpStatus.OK);
    }

}

package com.springboot.demo.mocky.EmployeeTest;

import com.springboot.demo.AOP.ControllerAdvice.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTestServiceImpl implements EmployeeTestService {

    private final EmployeeTestRepository employeeTestRepository;

    public EmployeeTestServiceImpl(EmployeeTestRepository employeeTestRepository) {
        this.employeeTestRepository = employeeTestRepository;
    }

    @Override
    public EmployeeTest saveEmployeeTest(EmployeeTest employeeTest) {

        try {
            Optional<EmployeeTest> savedEmployeeTest = employeeTestRepository.findByEmail(employeeTest.getEmail());
            if (savedEmployeeTest.isPresent()) {
                throw new ResourceNotFoundException("EmployeeTestAlready exist with given email:" + employeeTest.getEmail());
            }
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employeeTestRepository.save(employeeTest);
    }

    @Override
    public EmployeeTest updateEmployeeTest(EmployeeTest updatedEmployeeTest) {
        return employeeTestRepository.save(updatedEmployeeTest);
    }

    @Override
    public List<EmployeeTest> getAllEmployeesTest() {
        return employeeTestRepository.findAll();
    }

    @Override
    public Optional<EmployeeTest> getEmployeeTestById(long id) {
        return employeeTestRepository.findById(id);
    }

    @Override
    public void deleteEmployeeTest(long id) {
        employeeTestRepository.deleteById(id);
    }
}

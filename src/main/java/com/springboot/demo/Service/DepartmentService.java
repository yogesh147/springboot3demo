package com.springboot.demo.Service;

import com.springboot.demo.Model.Department;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department updateDepartment(Department department, Long departmentId);

    void deleteDepartmentById(Long departmentId);
}

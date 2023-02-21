package com.springboot.demo.Service;

import com.springboot.demo.Model.Department;
import com.springboot.demo.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department,
                                       Long departmentId) {
        final Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        Department depDB = new Department();
        if (departmentOptional.isPresent()) {
            depDB = departmentOptional.get();
        }
        if (StringUtils.hasText(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if (StringUtils.hasText(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (StringUtils.hasText(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(depDB);
    }
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
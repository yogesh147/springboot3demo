package com.springboot.demo.mocky.EmployeeTest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeTestRepository extends JpaRepository<EmployeeTest, Long> {

    Optional<EmployeeTest> findByEmail(String email);
}
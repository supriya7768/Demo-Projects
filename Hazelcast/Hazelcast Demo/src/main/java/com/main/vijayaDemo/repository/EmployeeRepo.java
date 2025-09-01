package com.main.vijayaDemo.repository;

import com.main.vijayaDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}

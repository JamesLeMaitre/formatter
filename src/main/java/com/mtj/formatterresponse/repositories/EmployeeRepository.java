package com.mtj.formatterresponse.repositories;

import com.mtj.formatterresponse.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

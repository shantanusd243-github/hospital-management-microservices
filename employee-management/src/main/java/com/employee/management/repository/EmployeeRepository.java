package com.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.model.Employee;

// interface extending crud repository
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}

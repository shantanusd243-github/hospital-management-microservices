package com.employee.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.management.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@Query(value="Select * from department where department_name=:departmentName",nativeQuery=true)
	 Optional<Department> findByDepartmentName(String departmentName);
}

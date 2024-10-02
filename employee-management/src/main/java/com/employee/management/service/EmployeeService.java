package com.employee.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;

// employee service class
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// fetching all employees
	public List<Employee> getAllEmployees(){
		List<Employee> emps = (List<Employee>)employeeRepository.findAll(); 
		return emps;
	}
	
	// fetching employee by id
	public Employee getEmployee(int id){
		return employeeRepository.findById(id).get();
	}
	
	// inserting employee
	public Employee addEmployee(Employee e) {
		return employeeRepository.save(e);
	}
	
	// updating employee by id
	public void updateEmployee(Employee emp, int id){
		if(id == emp.getEmployeeID()) {
			employeeRepository.save(emp);
		}
	}
	
	// deleting all employees
	public void deleteAllEmployees(){
		employeeRepository.deleteAll();
	}
	
	// deleting employee by id
	public void deleteEmployeeByID(int id){
		employeeRepository.deleteById(id);
	}
	
	//patching/updating employee by id
	public void patchEmployee(Employee emp, int id) {
		if(id == emp.getEmployeeID()) {
			employeeRepository.save(emp);
		}
	}
}

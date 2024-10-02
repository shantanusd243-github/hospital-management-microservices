package com.mirna.hospitalmanagementapi.domain.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mirna.hospitalmanagementapi.domain.dtos.EmployeeDTO;


@FeignClient(name="EMPLOYEE-MANAGEMENT")
public interface EmployeeServiceClient {
	@PostMapping("/employee/employeesviadto")
	EmployeeDTO addEmployees(@RequestBody EmployeeDTO employee);
	
	@GetMapping("/employee/{id}")
	EmployeeDTO getEmployee(@PathVariable int id);
}

package com.employee.management.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.DTO.CustomUserDetails;
import com.employee.management.DTO.EmployeeDTO;
import com.employee.management.jwt.JwtUtil;
import com.employee.management.model.Department;
import com.employee.management.model.Employee;
import com.employee.management.model.User;
import com.employee.management.repository.DepartmentRepository;
import com.employee.management.service.EmployeeService;
import com.employee.management.service.UserDetailsServiceImpl;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// displaying list of all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/api/auth/login")
	public ResponseEntity<Object> userLogin(@RequestBody User user){
		UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
		try {
			Authentication authObject = authenticationManager.authenticate(loginToken);
			System.out.println("authObject: "+authObject.toString());
			
			CustomUserDetails userObj = (CustomUserDetails) authObject.getPrincipal();
			
			String jwtToken = jwtUtil.generateJwtToken(userObj);
			
			return new ResponseEntity<>(jwtToken,HttpStatus.OK);
			
		}
		catch(BadCredentialsException e) {
			return new ResponseEntity<>("Login failed: Wrong Id or password",HttpStatus.UNAUTHORIZED);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/api/auth/register")
	public User userRegister(@RequestBody User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDetailsServiceImpl.saveUserDetails(user);
	}
	
	// displaying employee by id
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id){
		return employeeService.getEmployee(id);
	}
	
	// inserting employee
	@PostMapping("/employees")
	public Employee addEmployees(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
	
	@PostMapping("/employeesviadto")
	public Employee addEmployeesviaDTO(@RequestBody EmployeeDTO employee){
		Employee employeeEntity = new Employee();
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		Department department = departmentRepository.findByDepartmentName(employee.getDepartmentName()).get();
		employeeEntity.setDepartment(department);
		
		return employeeService.addEmployee(employeeEntity);
	}

	//updating employee by id
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Employee e, @PathVariable int id){
		employeeService.updateEmployee(e, id);
	}
	
	// deleting all employees
	@DeleteMapping("/employees")
	public void deleteAllEmployees(){
		employeeService.deleteAllEmployees();
	}

	// deleting employee by id
	@DeleteMapping("employees/{id}")
	public void deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id){
		employeeService.deleteEmployeeByID(id);
	}

	// updating/ patching employee by id
	@PatchMapping("employees/{id}")
	public void patchEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.patchEmployee(e, id);
	}
}

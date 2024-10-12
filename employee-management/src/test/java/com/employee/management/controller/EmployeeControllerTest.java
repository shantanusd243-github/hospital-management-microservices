package com.employee.management.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.employee.management.DTO.CustomUserDetails;
import com.employee.management.jwt.JwtUtil;
import com.employee.management.model.Employee;
import com.employee.management.model.User;
import com.employee.management.service.EmployeeService;
import com.employee.management.service.UserDetailsServiceImpl;

// This is the test class for EmployeeController
public class EmployeeControllerTest {

    // Mocking the EmployeeService to simulate its behavior without calling the actual service
    @Mock
    EmployeeService employeeService;
    
    // Mocking the UserDetailsServiceImpl for handling user-related operations
    @Mock
    UserDetailsServiceImpl userDetailsServiceImpl;
    
    // Mocking AuthenticationManager for user authentication during login
    @Mock
    AuthenticationManager authenticationManager;
    
    // Mocking JwtUtil for generating JWT tokens after successful authentication
    @Mock
    JwtUtil jwtUtil;
    
    // Mocking PasswordEncoder for encoding user passwords during registration
    @Mock
    PasswordEncoder passwordEncoder;

    // Injecting the mocks into the EmployeeController instance for testing
    @InjectMocks
    EmployeeController employeeController;

    // This method runs before each test to initialize mocks and inject them into the controller
    @BeforeEach
    void setUp() {
        // Initializes mocks created with the @Mock annotation
        MockitoAnnotations.openMocks(this);
    }

    // This test method verifies the behavior of the getAllEmployee() method of EmployeeController
    @Test
    void testGetAllEmployees() {
        // ARRANGE: Setting up the test data by creating Employee objects
        Employee emp1 = new Employee();
        emp1.setEmployeeID(1); // Setting employee ID
        emp1.setFirstName("Shantanu"); // Setting first name
        emp1.setLastName("Deshmukh"); // Setting last name

        Employee emp2 = new Employee();
        emp2.setEmployeeID(2); // Setting employee ID
        emp2.setFirstName("Kashmira"); // Setting first name
        emp2.setLastName("Deshmukh"); // Setting last name

        // Adding the two employees to a list
        List<Employee> empData = new ArrayList<>();
        empData.add(emp1);
        empData.add(emp2);

        // Mocking the behavior of employeeService.getAllEmployees()
        // When employeeService.getAllEmployees() is called in the test, it will return the empData list (mocked data)
        when(employeeService.getAllEmployees()).thenReturn(empData);

        // ACT: Calling the method in EmployeeController that we want to test
        List<Employee> data = employeeController.getAllEmployee();

        // ASSERT: Verifying that the controller returned the correct number of employees
        assertEquals(2, data.size()); // Assert that two employees are returned

        // ASSERT: Verifying that the first employee's first name is correct
        assertEquals("Shantanu", data.get(0).getFirstName());
        
        // ASSERT: Verifying that the second employee's first name is correct
        assertEquals("Kashmira", data.get(1).getFirstName());

        // Verifying that the employeeService.getAllEmployees() method was called exactly once during this test
        verify(employeeService, times(1)).getAllEmployees();
    }
    
    // This test method verifies the login process for the userLogin endpoint in EmployeeController
    @Test
    void loginEndpoint() {
        // ARRANGE: Setting up a mock user object for the login process
        User user = new User();
        user.setId(1); // Setting user ID
        user.setUserName("shantanu.xx@gmail.com"); // Setting user email
        user.setPassword("shantanu"); // Setting user password
        
        // Creating a UsernamePasswordAuthenticationToken with the user's credentials
        UsernamePasswordAuthenticationToken mockToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        
        // Mocking CustomUserDetails class to simulate user details retrieval during login
        CustomUserDetails customUserDetails = mock(CustomUserDetails.class);
        when(customUserDetails.getUsername()).thenReturn("shantanu.xx@gmail.com");
        
        // Mocking Authentication object to represent a successful authentication
        Authentication authObj = mock(Authentication.class);
        
        // Mocking the behavior of authenticationManager.authenticate() to return the mock Authentication object
        when(authenticationManager.authenticate(mockToken)).thenReturn(authObj);
        
        // Mocking the behavior of authObj.getPrincipal() to return CustomUserDetails
        when(authObj.getPrincipal()).thenReturn(customUserDetails);
        
        // Mocking the behavior of jwtUtil.generateJwtToken() to return a mocked JWT token
        when(jwtUtil.generateJwtToken(customUserDetails)).thenReturn("mockedJwtToken");
        
        // ACT: Calling the login endpoint and capturing the response
        ResponseEntity<Object> loggedData = employeeController.userLogin(user);
        
        // ASSERT: Verifying that the login was successful and the correct JWT token is returned
        assertEquals(HttpStatus.OK, loggedData.getStatusCode()); // Assert that the response status is OK
        assertEquals("mockedJwtToken", loggedData.getBody()); // Assert that the JWT token is correct
        
        // Optionally, verify that userDetailsServiceImpl.saveUserDetails() was never called (not needed during login)
        // verify(userDetailsServiceImpl, times(1)).saveUserDetails(user);
    }
    
    // This test method verifies the behavior when bad credentials are provided during login
    @Test
    void badCredentials() {
        // ARRANGE: Setting up a mock user object for testing bad credentials scenario
        User user = new User();
        user.setId(1); // Setting user ID
        user.setUserName("shantanu.xx@gmail.com"); // Setting user email
        user.setPassword("shantanu"); // Setting user password
        
        // Creating a UsernamePasswordAuthenticationToken with the user's credentials
        UsernamePasswordAuthenticationToken mockToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        
        // Mocking the behavior of authenticationManager.authenticate() to throw BadCredentialsException
        when(authenticationManager.authenticate(mockToken)).thenThrow(new BadCredentialsException("Bad credentials"));
        
        // ACT: Calling the login endpoint and capturing the response
        ResponseEntity<Object> loggedData = employeeController.userLogin(user);
        
        // ASSERT: Verifying that the response status is UNAUTHORIZED and the correct error message is returned
        assertEquals(HttpStatus.UNAUTHORIZED, loggedData.getStatusCode()); // Assert that the response status is UNAUTHORIZED
        assertEquals("Login failed: Wrong Id or password", loggedData.getBody()); // Assert that the error message is correct
    }
    
    // This test method verifies the user registration process for the userRegister endpoint in EmployeeController
    @Test
    void userRegisterationTest() {
        // ARRANGE: Setting up a mock user object for registration
        User user = new User();
        user.setId(1); // Setting user ID
        user.setUserName("shantanu.xx@gmail.com"); // Setting user email
        user.setPassword("shantanu"); // Setting user password
        
        // Mocking the behavior of passwordEncoder.encode() to return the plain password (as a simple mock)
        when(passwordEncoder.encode(user.getPassword())).thenReturn(user.getPassword());
        
        // Mocking the behavior of userDetailsServiceImpl.saveUserDetails() to return the mock user object
        when(userDetailsServiceImpl.saveUserDetails(user)).thenReturn(user);
        
        // ACT: Calling the registration endpoint and capturing the response
        User registerData = employeeController.userRegister(user);
        
        // ASSERT: Verifying that the registration was successful and the user details are correct
        assertEquals("shantanu.xx@gmail.com", registerData.getUserName()); // Assert that the email is correct
        assertEquals("shantanu", registerData.getPassword()); // Assert that the password is correct (already encoded)
    }
}

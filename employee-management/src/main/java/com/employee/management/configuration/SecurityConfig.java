package com.employee.management.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.employee.management.jwt.AuthenticationFilter;

/**
 * SecurityConfig is a configuration class that sets up Spring Security for the application.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Bean for password encoding using BCrypt.
     * This is used to securely hash passwords before storing them.
     *
     * @return a PasswordEncoder instance
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean for the AuthenticationManager, which is responsible for authenticating users.
     *
     * @param config the AuthenticationConfiguration
     * @return an AuthenticationManager instance
     * @throws Exception if an error occurs during authentication manager creation
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Autowired
    public AuthenticationFilter authenticationFilter; // Custom authentication filter

    /**
     * Security filter chain configuration.
     * This method configures HTTP security settings, including CSRF protection,
     * session management, and request authorization.
     *
     * @param http the HttpSecurity object to configure
     * @return a SecurityFilterChain instance
     * @throws Exception if an error occurs during filter chain configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable()) // Disable CSRF protection (not needed for stateless APIs)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Set session management to stateless
                .authorizeHttpRequests(req -> {
                    // Permit all POST requests to the authentication endpoint
                    req.requestMatchers(HttpMethod.POST, "/employee/api/auth/**").permitAll();
                    
                    req.requestMatchers("/employee/employees/**").hasRole("USER");
                    // Permit access to Swagger API documentation
                    req.requestMatchers("/v3/api-docs/**").permitAll();
                    req.requestMatchers("/swagger-ui/*").permitAll();
                    // Permit access to actuator endpoints for monitoring
                    req.requestMatchers("/actuator/**").permitAll();
                    // All other requests require authentication
                    req.anyRequest().authenticated();
                })
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class) // Add custom authentication filter
                .build(); // Build the security filter chain
    }
}

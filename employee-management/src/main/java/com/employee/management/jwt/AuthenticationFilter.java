package com.employee.management.jwt;

import java.io.IOException;
import java.util.stream.Stream;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.employee.management.DTO.CustomUserDetails;
import com.employee.management.service.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

/**
 * AuthenticationFilter is a Spring Security filter that processes incoming requests
 * to validate JWT tokens and set the authentication context.
 */
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    public JwtUtil jwtUtil; // Utility class for JWT operations

    @Autowired
    public UserDetailsServiceImpl userDetailsServiceImpl; // Service to load user details

    /**
     * This method is called for every request to validate the JWT token.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @param filterChain the FilterChain to continue the request processing
     * @throws ServletException if an error occurs during request processing
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Retrieve the Authorization header from the request
        String authToken = request.getHeader("Authorization");

        // Check if the token is null, blank, or does not start with "Bearer "
        if (authToken == null || authToken.isBlank() || !authToken.startsWith("Bearer ")) {
            throw new AuthenticationException("Authorization token is null or blank");
        }

        // Remove "Bearer " prefix from the token
        authToken = authToken.replaceAll("Bearer ", "");

        // Validate the JWT and extract user data
        String userData = jwtUtil.validateAndGetDataFromJwt(authToken);

        // Load user details using the extracted username
        CustomUserDetails user = (CustomUserDetails) userDetailsServiceImpl.loadUserByUsername(userData);

        // Create an authentication token for the user
        Authentication loginToken = new UsernamePasswordAuthenticationToken(user, null, null);

        // Set the authentication in the SecurityContext
        SecurityContextHolder.getContext().setAuthentication(loginToken);

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }

    /**
     * Determines whether the filter should be applied to the given request.
     *
     * @param request the HttpServletRequest
     * @return true if the filter should not be applied, false otherwise
     * @throws ServletException if an error occurs during request processing
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String url = request.getRequestURI();
        // Check if the request URI matches any of the excluded URLs
        return Stream.of(excluded_urls).anyMatch(x -> url.startsWith(x));
    }

    // List of URLs that should be excluded from authentication
    private static final String[] excluded_urls = {
            "/employee/api/auth","/actuator/", // Exclude authentication endpoint
    };
}

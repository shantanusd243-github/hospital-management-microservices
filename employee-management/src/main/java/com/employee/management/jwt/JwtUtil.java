package com.employee.management.jwt;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.employee.management.DTO.CustomUserDetails;

/**
 * JwtUtil is a utility class for generating and validating JSON Web Tokens (JWT).
 */
@Component
public class JwtUtil {

    @Value("${api.security.token.secret}") // Injects the secret key from application properties
    String secret;

    /**
     * Generates a JWT token for the given user.
     *
     * @param userObj the CustomUserDetails object containing user information
     * @return a signed JWT token as a String
     */
    public String generateJwtToken(CustomUserDetails userObj) {
        // Create an HMAC256 algorithm using the secret key
        Algorithm algo = Algorithm.HMAC256(secret);
        
        // Build the JWT token with issuer, subject, claims, and expiration time
        return JWT.create()
                .withIssuer("employee") // Set the issuer of the token
                .withSubject(userObj.getUsername()) // Set the subject (username)
                .withClaim("id", userObj.getId()) // Add a custom claim for user ID
                .withExpiresAt(LocalDateTime.now() // Set expiration time to 2 hours from now
                        .plusHours(2)
                        .toInstant(ZoneOffset.of("+05:30")))
                .sign(algo); // Sign the token with the algorithm
    }

    /**
     * Validates the given JWT token and extracts the user data.
     *
     * @param token the JWT token to validate
     * @return the subject (username) extracted from the token
     * @throws JWTVerificationException if the token is invalid or expired
     */
    public String validateAndGetDataFromJwt(String token) {
        // Create an HMAC256 algorithm using the secret key
        Algorithm algo = Algorithm.HMAC256(secret);
        
        // Create a JWT verifier with the specified algorithm and issuer
        JWTVerifier verifier = JWT.require(algo)
                .withIssuer("employee") // Set the expected issuer
                .build();
        
        // Verify the token and decode it
        DecodedJWT decodeJwt = verifier.verify(token);
        
        // Check if the token has expired
        if (decodeJwt.getExpiresAt().before(new Date())) {
            throw new JWTVerificationException("Token has been expired");
        }
        
        // Return the subject (username) from the decoded token
        return decodeJwt.getSubject();
    }
}

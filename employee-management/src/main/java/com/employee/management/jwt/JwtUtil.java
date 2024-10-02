package com.employee.management.jwt;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.employee.management.DTO.CustomUserDetails;
import com.employee.management.model.User;

@Component
public class JwtUtil {

	@Value("api.security.token.secret")
	String secret;
	
	public String generateJwtToken(CustomUserDetails userObj) {
		Algorithm algo = Algorithm.HMAC256(secret);
		return JWT.create().withIssuer("employee")
				.withSubject(userObj.getUsername())
				.withClaim("id",userObj.getId())
				.withExpiresAt(LocalDateTime.now()
		                 .plusHours(2)
		                 .toInstant(ZoneOffset.of("+05:30")))
				.sign(algo);
	}

}

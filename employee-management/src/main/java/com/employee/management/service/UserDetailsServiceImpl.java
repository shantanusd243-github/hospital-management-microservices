package com.employee.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employee.management.DTO.CustomUserDetails;
import com.employee.management.model.User;
import com.employee.management.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userObject = userRepository.findByUserName(username);
		CustomUserDetails customUserDetails = new CustomUserDetails(userObject.getId(),userObject.getUserName(),userObject.getPassword());
		return customUserDetails;
	}
	
	public User saveUserDetails(User user) {
		return userRepository.save(user);
	}

}

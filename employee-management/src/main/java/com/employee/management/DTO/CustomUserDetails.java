package com.employee.management.DTO;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
 private Integer id;
 private String username;
 private String password;

 public CustomUserDetails(Integer id,String username, String password) {
  this.id = id;
  this.username = username;
  this.password = password;
 }

 public Integer getId() {
	 return id;
 }


@Override
 public String getPassword() {
  return password;
 }

 @Override
 public String getUsername() {
  return username;
 }

 @Override
 public boolean isAccountNonExpired() {
  return true;
 }

 @Override
 public boolean isAccountNonLocked() {
  return true;
 }

 @Override
 public boolean isCredentialsNonExpired() {
  return true;
 }

 @Override
 public boolean isEnabled() {
  return true;
 }

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}
}
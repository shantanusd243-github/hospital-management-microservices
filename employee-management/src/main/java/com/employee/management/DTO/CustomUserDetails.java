package com.employee.management.DTO;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * CustomUserDetails is a custom implementation of the UserDetails interface
 * provided by Spring Security. It represents the user details used for authentication.
 */
public class CustomUserDetails implements UserDetails {
    private Integer id; // Unique identifier for the user
    private String username; // Username of the user
    private String password; // Password of the user
    Collection<? extends GrantedAuthority> roles; // user roles for authrorities

    /**
     * Constructor to initialize CustomUserDetails with user information.
     *
     * @param id       the unique identifier for the user
     * @param username the username of the user
     * @param password the password of the user
     */
    public CustomUserDetails(Integer id, String username, String password,Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles=roles;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return the user ID
     */
    public Integer getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password; // Returns the user's password
    }

    @Override
    public String getUsername() {
        return username; // Returns the user's username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Indicates that the account is not expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Indicates that the account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Indicates that the credentials are not expired
    }

    @Override
    public boolean isEnabled() {
        return true; // Indicates that the account is enabled
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
}

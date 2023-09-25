package com.example.medical_center.security;

import com.example.medical_center.dao.User;
import com.example.medical_center.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private boolean active;
    private Set<GrantedAuthority> role;

    public UserDetailsImpl(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.getActive();
        this.role = Set.of(new SimpleGrantedAuthority(user.getRole().toString()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
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
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}

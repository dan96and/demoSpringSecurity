package com.example.demospringsecurity.service;

import com.example.demospringsecurity.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.management.relation.Role;
import java.util.List;
import java.util.Set;

public interface UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities);
}

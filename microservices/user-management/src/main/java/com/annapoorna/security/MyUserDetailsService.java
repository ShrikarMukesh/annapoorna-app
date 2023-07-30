package com.annapoorna.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.annapoorna.repository.UserRepository;

// replace with your actual package
//other imports ...

@Service
public class MyUserDetailsService implements UserDetailsService {

 private final UserRepository userRepository;

 public MyUserDetailsService(UserRepository userRepository) {
     this.userRepository = userRepository;
 }

 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user = userRepository.findByUsername(username);
     if (user == null) {
         throw new UsernameNotFoundException("User not found");
     }

     return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
             user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList()));
 }
}



package com.annapoorna.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import com.annapoorna.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfiguration {

    // ... other configuration ...

    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configuration ...
            .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtUtil))
            .authorizeRequests()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/user/**").hasRole("USER");
    }

	private Object authenticationManager() {
		// TODO Auto-generated method stub
		return null;
	}
}

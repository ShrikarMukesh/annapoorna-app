package com.annapoorna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class UsermangSecurityConfig  {


     @Bean
	 SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) ->
		requests
		.requestMatchers("/admin/getAllUsers").authenticated()
		.requestMatchers("/users/**").permitAll())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}


     @Bean
     public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
         /*
         Approach 1 where we use withDefaultPasswordEncoder() method
         while creating the user details

         UserDetails admin = User.withDefaultPasswordEncoder()
                 .username("admin")
                 .password("12345")
                 .authorities("admin")
                 .build();

         UserDetails user1 = User.withDefaultPasswordEncoder()
                 .username("user")
                 .password("12345")
                 .authorities("read")
                 .build();

         UserDetails user2 = User.withDefaultPasswordEncoder()
                 .username("paul")
                 .password("12345")
                 .authorities("read")
                 .build();
         */


         //Approach 2 where we use NoOpPasswordEncoder Bean
 		//while creating the user details

         UserDetails admin = User.withUsername("admin")
                 .password("12345")
                 .authorities("admin")
                 .build();

         UserDetails user1 = User.withUsername("user1")
                 .password("12345")
                 .authorities("read")
                 .build();

         UserDetails user2 = User.withUsername("user2")
                 .password("12345")
                 .authorities("read")
                 .build();
         //InMemoryUserDetailsManager Accepts the Variable argument constructor
         return new InMemoryUserDetailsManager(admin,user1,user2);
     }

     @Bean
     public PasswordEncoder passwordEncoder(){
         return NoOpPasswordEncoder.getInstance();
     }
}

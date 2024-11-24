package com.example.ctsproject.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
           .csrf().disable() // Disable CSRF if not required
           .authorizeRequests()
               .requestMatchers("/api/registration").permitAll() // Allow public access to the registration endpoint
               .requestMatchers("/api/admin/**").hasRole("ADMIN") // Restrict admin endpoints
               .anyRequest().authenticated()
           .and()
           .httpBasic(); // Enable Basic Authentication
       return http.build();
   }
}

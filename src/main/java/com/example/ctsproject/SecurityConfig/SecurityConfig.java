package com.example.pcms_backend.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http.csrf().disable()
           .authorizeHttpRequests(auth -> auth
               .requestMatchers("/api/users/register").permitAll()
               .requestMatchers("/api/users/approve/**", "/api/users/reject/**").hasRole("ADMIN")
               .anyRequest().authenticated()
           )
           .httpBasic();
       return http.build();
   }
}
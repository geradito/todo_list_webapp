package com.enrollzambia.todoapp.todoappapi.security;

import java.io.Console;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.enrollzambia.todoapp.todoappapi.service.UserService2;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
	    UserDetails user = User.withUsername("user")
	      .password(passwordEncoder().encode("userPass"))
	      .build();
	    return new InMemoryUserDetailsManager(user);
	}
	
//  @Bean
//  public UserDetailsService userDetailsService() {
//      return new MyUserDetails();
//  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(
          AuthenticationConfiguration authConfig) throws Exception {
      return authConfig.getAuthenticationManager();
  }
  
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService());
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

      // Enable CORS and disable CSRF
      http = http.csrf().disable();
      http = http.cors().disable();
      
      // Set session management to stateless
      http = http.sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and();
      
    http.authorizeHttpRequests(
            auth -> auth.requestMatchers("/api/login", "/api/signup").permitAll()
            .anyRequest().authenticated()
           )
            .logout(logout -> logout.logoutUrl("/signout").permitAll());
 
    
      return http.build();
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
      return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
  }

}

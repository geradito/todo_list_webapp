//package com.enrollzambia.todoapp.todoappapi.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
// 
//@Configuration
//public class SecurityConfig {
// 
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return new ShopmeUserDetailsService();
////    }
// 
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
// 
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//     
//        http.authorizeRequests().requestMatchers("/login").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("/login")
//                    .usernameParameter("email")
//                    .permitAll()
//                .and()
//                .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
//                .and()
//                .logout().permitAll();
// 
//        http.headers().frameOptions().sameOrigin();
// 
//        return http.build();
//    }
// 
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
//    }
// 
//}
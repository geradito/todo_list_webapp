//package com.enrollzambia.todoapp.todoappapi.service;
//
//import java.awt.PageAttributes.MediaType;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.filter.GenericFilterBean;
//
//import com.enrollzambia.todoapp.todoappapi.dao.UserDAO;
//import com.enrollzambia.todoapp.todoappapi.dao.UserDAOImpl;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//
//@Service
//public class AuthenticationFilter extends GenericFilterBean {
//
//	UserDAOImpl userDAO = new UserDAOImpl();
//	
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
//      throws IOException, ServletException {
//        try {
//            Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest) request, userDAO);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        } catch (Exception exp) {
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            httpResponse.setContentType("application/json");
//            PrintWriter writer = httpResponse.getWriter();
//            writer.print(exp.getMessage());
//            writer.flush();
//            writer.close();
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//}
//package com.enrollzambia.todoapp.todoappapi.service;
//
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.AuthorityUtils;
//
//import com.enrollzambia.todoapp.todoappapi.dao.UserDAO;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//public class AuthenticationService {
//	 private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
////	    private static final String AUTH_TOKEN = "Baeldung";
//
//	    public static Authentication getAuthentication(HttpServletRequest request,UserDAO userDAO) {
//	        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
//	        String pathInfo = request.getRequestURI().substring(request.getContextPath().length());
//	        
//	         
//	        //if a user is signing up or logging in, ignore auth 
//	        if (pathInfo.equals("/api/signup") || pathInfo.equals("/api/login")) {
//	            return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
//	      	}
//	        
//	        if (apiKey == null || !apiKey.equals(userDAO.verifyToken(apiKey))) {
//	            throw new BadCredentialsException("Invalid API Key "+pathInfo);
//	        }
//
//	        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
//	    }
//}
//
//

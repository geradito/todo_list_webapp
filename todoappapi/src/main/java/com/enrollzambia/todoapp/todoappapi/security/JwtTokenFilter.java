package com.enrollzambia.todoapp.todoappapi.security;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import org.springframework.web.filter.OncePerRequestFilter;

import com.enrollzambia.todoapp.todoappapi.exception.CustomException;

// We should use OncePerRequestFilter since we are doing a database call, there is no point in doing this more than once
public class JwtTokenFilter extends OncePerRequestFilter {


  private JwtTokenProvider jwtTokenProvider;

  public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

@Override
protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
		jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
		throws jakarta.servlet.ServletException, IOException {
	  String token = jwtTokenProvider.resolveToken(request);
	    try {
	      if (token != null && jwtTokenProvider.validateToken(token)) {
	        Authentication auth = jwtTokenProvider.getAuthentication(token);
	        SecurityContextHolder.getContext().setAuthentication(auth);
	      }
	    } catch (CustomException ex) {
	      //this is very important, since it guarantees the user is not authenticated at all
	      SecurityContextHolder.clearContext();
	      response.sendError(ex.getHttpStatus().value(), ex.getMessage());
	      return;
	    }

	    filterChain.doFilter(request, response);
}

}
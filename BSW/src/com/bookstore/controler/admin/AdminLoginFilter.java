package com.bookstore.controler.admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    
    public AdminLoginFilter() {
      
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpSession session =httpRequest.getSession(false);
		boolean loggedIn=session !=null && session.getAttribute("userEmail") !=null;
		String loggedInUrl=httpRequest.getContextPath() +"/admin/login";
		boolean loggedInRequest=httpRequest.getRequestURI().equals(loggedInUrl);
		if(loggedIn || loggedInRequest) {
			chain.doFilter(request, response);
		}
		else {
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("login.jsp");
			requestdispatcher.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

package com.bookstore.controller.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.base.controller.BaseServlet;
import com.bookstore.service.book.BookService;


@WebServlet("/search")
public class CreateSearchBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	
	public CreateSearchBookServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String keyword=request.getParameter("keyword");
		
		BookService BookService= new BookService( request, response);
		BookService.searchBook();
		

	}

}
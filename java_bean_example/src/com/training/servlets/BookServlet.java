package com.training.servlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.services.BookService;
import com.training.utils.ConnectionFactory;
import java.util.*;
import com.example.demo.model.*;
/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/books")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection con =null;
       private BookService service =null;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void destroy() {

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void init() throws ServletException {

		try {
			con = ConnectionFactory.getPostgressConnection();
			
			 service = new BookService(con);
			
			System.out.println("Connection:="+ con);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Book> books = service.findAll();
		
		   request.setAttribute("books", books);
		   
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
		   dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String strBookNumber = request.getParameter("bookNumber");
	 	int bookNumber = Integer.parseInt(strBookNumber);
	 
	String bookName = request.getParameter("bookName");
	String authorName = request.getParameter("authorName");
	String strPrice = request.getParameter("price");
		double price = Double.parseDouble(strPrice);
		
		
		Book entity = new Book(bookNumber, bookName, authorName, price);
		
	Book addedBook=	service.add(entity);
	
	request.setAttribute("added",addedBook);
	request.setAttribute("message", "One Book Added");
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/addBook.jsp");
	dispatcher.forward(request, response);
	

	
	
	}

}

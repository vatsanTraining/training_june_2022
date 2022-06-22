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
@WebServlet("/")
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

			con = ConnectionFactory.getPostgressConnection();
			
			 service = new BookService(con);
			
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String key = request.getServletPath();
		
		System.out.println(key);
		
		switch (key) {
		case "/books":
			handleFindAll(request, response);
			break;
		case "/delete":
			handleRemove(request, response);
			break;
		case "/edit":
			handleEdit(request, response);
			break;
			
		default:
			break;
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String key = request.getServletPath();
		
		System.out.println(key);

		
		switch (key) {
		case "/books":
			handleAdd(request,response);
			break;
		case "/update":
			handleUpdate(request,response);
			break;

		default:
			break;
		}
		

	
	
	}

	private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strBookNumber = request.getParameter("bookNumber");
	 	int bookNumber = Integer.parseInt(strBookNumber);
	 
	String bookName = request.getParameter("bookName");
	String authorName = request.getParameter("authorName");
	String strPrice = request.getParameter("price");
		double price = Double.parseDouble(strPrice);
		
		
		Book entity = new Book(bookNumber, bookName, authorName, price);
		
	Book updated=	service.update(entity);
	
	
	List<Book> books = service.findAll();
	
	   request.setAttribute("books", books);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
			dispatcher.forward(request, response);
	}


	private void handleAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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


	public void handleEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		 String strId =request.getParameter("id");
		 
		 int id = Integer.parseInt(strId);
		 

		 Book bookToEdit = service.findById(id);
		 
		 service.update(bookToEdit);
		 request.setAttribute("bookToEdit", bookToEdit);
		 
		 
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/addBook.jsp");
		dispatcher.forward(request, response);
		
		 
	}
	
	public void handleRemove(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		 String strId =request.getParameter("id");
		 
		 int id = Integer.parseInt(strId);
		 
		Book book= service.remove(id);
		 
		List<Book> books = service.findAll();
		
		   request.setAttribute("books", books);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
		dispatcher.forward(request, response);
		
		 
	}
	
	public void handleFindAll(HttpServletRequest request,HttpServletResponse response) 
			     throws ServletException, IOException{
		List<Book> books = service.findAll();
		
		   request.setAttribute("books", books);
		   
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
		   dispatcher.forward(request, response);

	}
	}

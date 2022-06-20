package com.training.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.model.Book;
import com.training.services.BookService;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   private BookService service;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
    }
    
	@Override
	public void init() throws ServletException {
		 service = new BookService();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		 String action = request.getServletPath();
		 
		switch (action) {
		case "/":
			 showIndex(request,response);
			break;
		case "/addBook":
		     sendAddBookPage(request,response);
		    break;
		case "/findBooks":
			 findBooks(request,response);
			 break;
		case "/findByName":
			 findBookByName(request,response);
			 break;
			 
		default:
			break;
		}
		
		
	}

	private void findBookByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookName = request.getParameter("bookName");
		
		List<Book> bookList=service.findBookByName(bookName);
		
	       request.setAttribute("books", bookList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
		dispatcher.forward(request, response);
	

	}

	private void findBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> bookList=service.findAll();
		
	       request.setAttribute("books", bookList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
		dispatcher.forward(request, response);
		
	}

	private void sendAddBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/addBook.jsp");
		dispatcher.forward(request, response);
	
	}

	private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
		dispatcher.forward(request, response);
		
		
	}

}

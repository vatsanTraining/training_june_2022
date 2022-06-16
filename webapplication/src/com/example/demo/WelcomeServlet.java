package com.example.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.Student;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/")
public class WelcomeServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String action = request.getServletPath();
		
		//System.out.println("Action :="+action);
		
		switch (action) {
		case "/":
			 welcomePage(request,response);
			break;
		case "/add":
			 addPage(request,response);
			 break;
		case "/show":
			 showPage(request,response);
			 break;
		default:
			break;
		}
		
				
	}

	private void showPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setAttribute("heading", "Gandhi School");
			
		  String strRollNumber = request.getParameter("rollNumber");
		  int rollNumber = Integer.parseInt(strRollNumber);
		  
		  String studentName = request.getParameter("studentName");
		  
			
		  String strMark = request.getParameter("mark");
		  double mark = Double.parseDouble(strMark);
		  
		  Student obj = new Student(rollNumber,studentName,mark);
		  
		  request.setAttribute("added", obj);
		  
		  
		RequestDispatcher dispathcer = request.getRequestDispatcher("/showStudent.jsp");
		 dispathcer.forward(request, response);
		
	}

	private void addPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  request.setAttribute("heading", "Gandhi School");
		
		RequestDispatcher dispathcer = request.getRequestDispatcher("/addStudent.jsp");
		 dispathcer.forward(request, response);
			
	}

	private void welcomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
		request.setAttribute("heading", "Gandhi School");
		
		RequestDispatcher dispathcer = request.getRequestDispatcher("/home.jsp");
		 dispathcer.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

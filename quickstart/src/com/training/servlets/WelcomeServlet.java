package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();

        System.out.println("Constructor Called ====================");
      //  System.out.println("Name :="+getServletConfig().getServletName());
    }

	@Override
	public void destroy() {

		System.out.println("DESTROY METHOD CALLED ****************");
	}

	@Override
	public void init() throws ServletException {
		
		// Can access config information only inside the init() method but not in constructor
		// but both of them are called only once

		System.out.println("INIT Method Called ######################");
        System.out.println("NAME :="+getServletConfig().getServletName());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// System.out.println(request.getClass().getName());
		// System.out.println(response.getClass().getName());
		
	   //System.out.println("DO GET CALLED **************");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
		
		 dispatcher.forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}

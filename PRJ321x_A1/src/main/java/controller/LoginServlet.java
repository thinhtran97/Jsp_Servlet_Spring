package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=UTF-8") ;
		request.setCharacterEncoding("UTF-8"); // vietnamese
		try {
		//collect data from a login form
		String userID = request.getParameter("username");
		String password = request.getParameter("password");
		//read information of account in web.xml
		String uid = getServletConfig().getInitParameter("username");
		String pwd = getServletConfig().getInitParameter("password");
		//check account — use validate code in assignment 1 to valid user
		if (userID != null & password.equals(pwd) && userID.equalsIgnoreCase(uid)) {
		response.sendRedirect("home.jsp");
		} else {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		response. getWriter().println("<font color='red'>Username or password is invalid</font>");
		rd.include(request, response);
		}
		} catch (Exception ex) {
		response. getWriter().println(ex);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html; charset=UTF-8") ;
			request.setCharacterEncoding("UTF-8"); // vietnamese
			//collect data from a login form
			String userID = request.getParameter("username");
			String password = request.getParameter("password");
			//read information of account in web.xml
			String uid = getServletConfig().getInitParameter("username");
			String pwd = getServletConfig().getInitParameter("password");
			//check account — use validate code in assignment 1 to valid user
			if (userID != null & password.equals(pwd) && userID.equalsIgnoreCase(uid)) {
			response.sendRedirect("home.jsp");
			} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			response. getWriter().println("<font color='red'>Username or password is invalid</font>");
			rd.include(request, response);
			}
			} catch (Exception ex) {
			response. getWriter().println(ex);
			}
	}

}

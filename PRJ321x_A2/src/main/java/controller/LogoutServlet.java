package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		String action = request.getParameter("action");
		
		//check account — use validate code in assignment 1 to valid user
		if (action==null) {
		response.sendRedirect("index.jsp");
		} else if (action.equals("logout")){
//		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//		rd.include(request, response);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
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
//		doGet(request, response);
		
		Cookie cUserName = new Cookie("cookuser", null);
		Cookie cPassword = new Cookie("cookpass", null);
		Cookie cRemember = new Cookie("cookrem", null);
		cUserName.setMaxAge(0);
		cPassword.setMaxAge(0);
		cRemember.setMaxAge(0);
		response.addCookie(cUserName);
		response.addCookie(cPassword);
		response.addCookie(cRemember);
		//HttpSession httpSession = request.getSession();
		HttpSession session = request.getSession();

		session.invalidate();
		request.setAttribute("msg", "You have successfully logged out.");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
		requestDispatcher.forward(request, response);
	}

}

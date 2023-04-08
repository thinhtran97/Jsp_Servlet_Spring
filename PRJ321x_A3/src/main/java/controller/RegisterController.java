package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doPost(request, response);
		
		request.getSession(true).invalidate();
		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");
		
		if (action == null) {
		    request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (action.equals("register")) {
		    session.removeAttribute("userMail");
		    session.removeAttribute("name");
		    session.removeAttribute("address");
		    session.removeAttribute("phone");
		    request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		processRequest(request, response);

		
		
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // vietnamese
		try {
		    String action = request.getParameter("action");
		    if (action == null) {
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		    } else if (action.equals("doReg")) {
			AccountDAO accDao = new AccountDAO();
			request.getSession(true).invalidate();
			// make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			// collect data form a login here
			String userMail = request.getParameter("userMail");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phoneN = request.getParameter("phone");
			HttpSession session = request.getSession(true);
			if (!password.matches(regex) || !userMail.matches(regexMail)) {
			    session.setAttribute("userMail", userMail);
			    session.setAttribute("name", name);
			    session.setAttribute("address", address);
			    session.setAttribute("phone", phoneN);
			    session.setAttribute("error", "Email or Password invalid systax !");
			    response.sendRedirect("register.jsp");
			}else if (accDao.checkExitMail(userMail)) {
			    session.setAttribute("userMail", userMail);
			    session.setAttribute("name", name);
			    session.setAttribute("address", address);
			    session.setAttribute("phone", phoneN);
			    session.setAttribute("error", "UserName/Email already exists !");
			    response.sendRedirect("register.jsp");
			}else {
			    accDao.insertAccount(userMail, password, name, address, phoneN);
			    // set session
			    session.setAttribute("username", userMail);
			    session.removeAttribute("userMail");
			    session.removeAttribute("name");
			    session.removeAttribute("address");
			    session.removeAttribute("phone");
			    response.sendRedirect("login.jsp");
			}
		    }

		} catch (NullPointerException e) {
		    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		    rd.forward(request, response);
		} catch (Exception e) {
		    response.getWriter().println(e);
		}

	    }

}

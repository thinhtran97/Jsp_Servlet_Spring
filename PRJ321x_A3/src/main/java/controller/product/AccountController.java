package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import model.Account;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//    	processRequest(request, response);
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()){
		    List<Account> ls = new AccountDAO().listAccount(1);
		    request.setAttribute("listS", ls);
		    RequestDispatcher rd = request.getRequestDispatcher("admin/index.jsp");
		    rd.forward(request, response);
		} catch (Exception ex) {
//		    Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()){
		    List<Account> ls = new AccountDAO().listAccount(1);
		    request.setAttribute("listS", ls);
		    RequestDispatcher rd = request.getRequestDispatcher("admin/index.jsp");
		    rd.forward(request, response);
		} catch (Exception ex) {
//		    Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()){
		    List<Account> ls = new AccountDAO().listAccount(1);
		    request.setAttribute("listS", ls);
		    RequestDispatcher rd = request.getRequestDispatcher("admin/index.jsp");
		    rd.forward(request, response);
		} catch (Exception ex) {
//		    Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }

}

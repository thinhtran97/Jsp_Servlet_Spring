package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDAO;
import model.Cart;
import model.Orders;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/PayController")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/htm1l; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {

			HttpSession session = request.getSession(true);

//			if (session.getAttribute("cart") == null) {
//
//				OrdersDAO dao = new OrdersDAO();
//
//				Cart c = (Cart) session.getAttribute("cart");
//
//				String username = request.getParameter("name");
//
//				String discount = request.getParameter("discount");
//
//				String address = request.getParameter("address");
//
//				Orders d = new Orders(2, address, "", username, null, discount);
//				dao.insertOrder(d, c);
//
//				response.sendRedirect("index.jsp");
//			}
//
//		} catch (Exception ex) {
//			response.getWriter().println(ex);
//
//			ex.printStackTrace();
//		}
			
			
			if (session.getAttribute("cart") == null) {
			    request.getRequestDispatcher("AddToCartController").forward(request,response);
			}else {
			    Cart c = (Cart) session.getAttribute("cart");
			    if (c.getItems().size()==0) {
				request.getRequestDispatcher("AddToCartController").forward(request,response);
			    }
			    OrdersDAO dao = new OrdersDAO();
			    String username = request.getParameter("email");
			    String discount = request.getParameter("discount");
			    String address = request.getParameter("address");
			    Orders order = new Orders(2, address, "", username, null, discount);
			    dao.insertOrder(order, c);
			    session.setAttribute("cart", null);
			    request.setAttribute("completed", 1);
			    request.getRequestDispatcher("cart.jsp").forward(request,response);
			}
			
			
		    } catch (Exception e) {
			response.getWriter().println(e);
			e.printStackTrace();
		    }

	}

}

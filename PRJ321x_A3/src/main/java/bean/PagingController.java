package bean;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PagingDAO;
import model.Product;

/**
 * Servlet implementation class PagingController
 */
@WebServlet("/PagingController")
public class PagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PagingController() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");

		String indexPage = request.getParameter("index");
		if (indexPage == null) indexPage = "1";

		int index = Integer.parseInt(indexPage);

		PagingDAO pagDao = new PagingDAO();
		int count = pagDao.getTotalProduct();
		int endPage = count / 3;
		if (count % 3 != 0)
			endPage++;

		List<Product> list = pagDao.pagingProduct(index);

		request.setAttribute("listP", list);
		request.setAttribute("endP", endPage);
		request.setAttribute("indexPage", index);

		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request, response);

	}

}

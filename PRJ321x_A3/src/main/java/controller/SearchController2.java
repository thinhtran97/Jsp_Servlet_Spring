package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class SearchController2
 */
@WebServlet("/SearchController2")
public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response. setContentType("text/htm1l; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		try {
		String find = request.getParameter("search");
		String indexSearch = request.getParameter("index");
		if(indexSearch==null) indexSearch = "1";
		int indexPS = Integer.parseInt(indexSearch);
		
		ListProductDAO lpd = new ListProductDAO();
		List<Product> listPS = lpd.search(find, indexPS);
		int total = lpd.getTotalProductSearch(find);
		int endPage = total/3;
		if(total % 3 != 0) endPage++;
		
		if (listPS.size() == 0) {
		    request.setAttribute("messeger", "Oop! No results found!");
		}
		
		request.setAttribute("searchPS", find);
		request.setAttribute("endPS", endPage);
		request.setAttribute("indexPS", indexPS);
		request.setAttribute("listPS", listPS );
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd. forward(request, response) ;

		} catch (Exception ex) {
		response. getWriter().println(ex);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

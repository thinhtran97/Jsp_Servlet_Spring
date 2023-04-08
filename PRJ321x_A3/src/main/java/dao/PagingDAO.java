package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class PagingDAO {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	 public List<Product> getAllProduct() {
	        List<Product> list = new ArrayList<>();
	        String query = "select * from account";
	        try {
	            conn = new DBContext().getJDBCConnection();
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	            while(rs.next()){
	                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
							rs.getString(6), rs.getString(7)));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }
	 
	 
		

		 
		 //dem so luong account trong db
		 public int getTotalProduct () {
		 String query = "select count (*) from Products" ;
		 try {
	            conn = new DBContext().getJDBCConnection();
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	            while(rs.next()){
	                return rs.getInt(1);
	            }
	        } catch (Exception e) {
	        }
	        return 0;
		 
	 }

	public List<Product> pagingProduct(int index) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Products \n" + "order by product_id \n" + "offset ? rows fetch next 3 rows only;";

		try {
			conn = new DBContext().getJDBCConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*3);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
	
	public static void main(String[] args) {
		PagingDAO dao = new PagingDAO();
		List<Product> list = dao.pagingProduct(2) ;
		for (Product o : list) {
			String a = o.hienthi();

		System.out.println(a) ;
		}
		
			
			int count = dao.getTotalProduct() ;
			System. out.println ("tổng: "+ count) ;
			
		}

}

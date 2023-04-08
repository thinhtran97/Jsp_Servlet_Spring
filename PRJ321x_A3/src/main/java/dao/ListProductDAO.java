package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import context.DBContext;
import model.Product;

public class ListProductDAO {
	
//	public static int count;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
//	public int count;
//	public int count;
	
	
	public ListProductDAO() {
		
	}
	//return the list of products by product name
	public List<Product> search(String characters, int index) throws Exception {
		List<Product> list = new ArrayList<>();
		String query1 = "select * from Products where product_name like ? \n"
		+ "order by product_id \n"
		+ "offset ? rows fetch next 3 rows only;";
		

		
		 conn = new DBContext().getJDBCConnection();
		 ps = conn.prepareStatement(query1);
		ps.setString(1, "%" + characters + "%");
		ps.setInt(2, (index-1)*3);
		rs = ps.executeQuery();
		while(rs.next()) {list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
				rs.getString(6), rs.getString(7)));		
		}
		
//		String query2 = "select count (*) from Products where product_name like '%?%';" ;
//		Connection conn2 = new DBContext().getConnection();
//		PreparedStatement ps2 = conn2.prepareStatement(query2);
//		ps2.setString(1, "characters");
//		ResultSet rs2 = ps2.executeQuery();
//		count = rs2.getInt(1);
		
		
		conn.close();
		
		return list; 
		
	}
	
	 public int getTotalProductSearch (String characters) {
		 String query = "select count * from Products where product_name like ?;" ;
		 try {
	            conn = new DBContext().getJDBCConnection();
	            ps = conn.prepareStatement(query);
	            ps.setString(1, "%" + characters + "%");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                return rs.getInt(1);
	            }
	        } catch (Exception e) {
	        }
	        return 0;
		 
	 }

	//get the product
	public Product getProduct(String characters) throws Exception {
		Product product = new Product();
		String query = "select * from Products where product_id = ?" ;
		
		conn = new DBContext().getJDBCConnection();
		ps = conn.prepareStatement(query);
		ps.setInt(1, Integer.parseInt(characters));
		rs = ps.executeQuery();
		while(rs.next()) {
		 product.setId(rs.getInt(1));
		 product.setName(rs.getString(2));
		 product.setDescription(rs.getString(3));
		 product.setPrice(rs.getFloat(4));
		 product.setSrc(rs.getString(5));
		 product.setType(rs.getString(6));
		 product.setBrand(rs.getString(7));
		}
		conn.close();
		
				
		
		return product;
		
	}
	
	

}

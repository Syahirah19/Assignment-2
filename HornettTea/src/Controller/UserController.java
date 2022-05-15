package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.ItemProduct;
import Controller.DBConnect;

public class UserController {
	
	public List<ItemProduct> getAllItems() throws SQLException{
		List<ItemProduct> items = new ArrayList<>();
		
		Connection conn = DBConnect.doConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from itemproduct");
		while(rs.next()) {
			items.add(new ItemProduct(rs.getInt("ItemProductId"), 
					rs.getString("Name"), rs.getString("LabelName"),rs.getDouble("Price")));
		}
		return items;
	}
}
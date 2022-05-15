package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Order;

public class OrderRecord {

	public int insertOrder(Order order) 
			throws ClassNotFoundException, SQLException
	{
		int success = -1;
		String sql = "insert into `order` "
				+ "(OrderNumber, GrandTotal, TenderedCash, `Change`, "
				+ "TotalOrderItem, SubTotal, Rounding, ServiceTax) "
				+ "values(?,?,?,?,?,?,?,?)";


		Connection conn = DBConnect.doConnection();

		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, order.getOrderNumber());
		preparedStatement.setDouble(2, order.getGrandTotal());
		preparedStatement.setDouble(3, order.getTenderedCash());
		preparedStatement.setDouble(4, order.getChange());
		preparedStatement.setInt(5, order.getTotalOrderItem());
		preparedStatement.setDouble(6, order.getSubTotal());
		preparedStatement.setDouble(7, order.getRounding());
		preparedStatement.setDouble(8, order.getServiceTax());

		success = preparedStatement.executeUpdate();

		conn.close();
		return success; 
	}

}

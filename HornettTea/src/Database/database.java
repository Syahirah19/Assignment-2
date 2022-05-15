package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Database

public class database {

	static Connection conn=null;
	public static Connection doConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");


		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost/ht_db2","root","");
		return conn;
	}



	public static void main(String[] args) 
	{
		try 
		{
			System.out.println(database.doConnection()+" Sucessfull");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}

	}

}
	

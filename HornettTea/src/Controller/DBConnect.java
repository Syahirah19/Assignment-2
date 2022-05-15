package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;

public class DBConnect {
	
	public static Connection doConnection(){
		
	Connection conn=null;
	
	try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/ht_db", "root", "");
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    
    return conn;
}

}    
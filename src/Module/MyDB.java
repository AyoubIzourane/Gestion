package Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDB {
	static Connection cn;
	static Statement st;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_notes","root","");
			st=cn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	
	
	public static int insert_login(Login login) {
		try {
			String sql = "insert into login values("+login.getId_login()+",'"+login.getUsername()+"','"+login.getPassword()+"',"+login.isRole()+")";
			Connection cn = MyDB.getConnection();
			st.executeUpdate(sql);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	

}

package Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDB {
	static Connection cn;
	static Statement statement;
	static ResultSet resultSet;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/gestion_notes", "root", "");
			statement=cn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	
	
	public static boolean insertAccount(Login login) {
		try {
			String sql = "insert into login values("+login.getId_login()+",'"+login.getUsername()+"','"+login.getPassword()+"',"+login.isRole()+")";
			Connection cn = MyDB.getConnection();
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static boolean checkAccount(String username,String password) {
		boolean res = false;
		try {
			String sql = "select username,password from login where username='"+ username +"' and password='"+password+"'";
			Connection cn = MyDB.getConnection();

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	

}

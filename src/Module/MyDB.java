package Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDB {
	static Connection cn;
	static Statement st;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_notes","root","ayoub");
			st=cn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	
	
	public static int insertAccount(User user) {
		try {
			String sql = "insert into user(id_user,username,password,role) values("+user.getId_user()+",'"+user.getUsername()+"','"+user.getPassword()+"',"+user.isRole()+")";
			Connection cn = MyDB.getConnection();
			st.executeUpdate(sql);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String showFullname(User user) {
		try {
			String sql = "select full_name from user where username = '"+user.getUsername()  +"' ";
			Connection cn = MyDB.getConnection();
			ResultSet rs = st.executeQuery(sql);
			return String.valueOf(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}

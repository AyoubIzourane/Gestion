package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Person;
import model.User;

public class MyDB {
	public static Connection cn;
	public static Statement st;
	public static ResultSet rs;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/jeeproject","root","");
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
			cn = MyDB.getConnection();
			st.executeUpdate(sql);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	//replace the last method with this
	public static User getUser(String username) throws SQLException {
		User user = new User();
		String sql = "select full_name from user where username = '"+username +"'";
		cn = MyDB.getConnection();
		rs = st.executeQuery(sql);
		
		while(rs.next()){
			user.setFull_name(rs.getString(1));
		}
		return user;
		
	}
	
	
	public static Person getPerson(String username) throws SQLException {
		Person p = new Person();
		String sql = "select id_person,first_name,last_name from person where username = '"+username +"'";
		cn = MyDB.getConnection();
		rs = st.executeQuery(sql);
		
		while(rs.next()){
			p.setId_user(Integer.parseInt(rs.getString(1)));
			p.setFname(rs.getString(2));
			p.setLname(rs.getString(3));
		}
		return p;
		
	}
	
	
	public static boolean checkAccountAdmin(String username,String password) {
		boolean res = false;
		try {
			String sql = "select username,password from person where username='"+ username +"' and password='"+password
					+"' and role = 1";
			cn = MyDB.getConnection();

			rs = st.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	public static boolean checkAccount(String username,String password) {
		boolean res = false;
		try {
			String sql = "select username,password from person where username='"+ username +"' and password='"+password
					+"' and role = 0 ";

			cn = MyDB.getConnection();

			rs = st.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	

}
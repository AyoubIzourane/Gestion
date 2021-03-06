package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class User{
	
	private int id_user;
	private String full_name;
	private String username;
	private String password;
	private String email;
	private String phone;
	private boolean role;
	
	public User() {
	}
	
	/*public User(String username, String password, boolean role) {
		this.id_user++;
		this.username = username;
		this.password = password;
		this.role = role;
	}*/
	

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String fname) {
		this.full_name = fname;
	}
	


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}
	
	

}

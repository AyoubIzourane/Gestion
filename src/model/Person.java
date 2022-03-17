package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="person_type")
public class Person implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_person")
	private int id_person;
	@Column(name="first_name",length = 50)
	private String fname;
	@Column(name="last_name",length = 50)
	private String lname;
	@Column(name="username", unique=true, length = 50)
	private String username;
	@Column(name="password",length = 50)
	private String password;
	@Column(name="email", unique=true, length = 50)
	private String email;
	@Column(name="phone",length = 50)
	private String phone;
	@Column(name="role")
	private boolean role;
	
	
	
	public Person() {
	}
	
	/*public User(String username, String password, boolean role) {
		this.id_user++;
		this.username = username;
		this.password = password;
		this.role = role;
	}*/
	

	public int getId_user() {
		return id_person;
	}

	public void setId_user(int id_person) {
		this.id_person = id_person;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
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

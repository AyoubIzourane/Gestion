package Module;

public class Login {
	
	private static int id_login=0;
	private String username;
	private String password;
	private boolean role;
	
	public Login() {
		
	}
	
	
	public Login(String username, String password, boolean role) {
		this.id_login++;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	
	public static int getId_login() {
		return id_login;
	}
	public static void setId_login(int id_login) {
		Login.id_login = id_login;
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
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	
	

}

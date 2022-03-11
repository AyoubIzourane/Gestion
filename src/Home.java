import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Module.Login;
import Module.MyDB;

@WebServlet(name="Home", urlPatterns="/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        	 String username = request.getParameter("username");
      		String password = request.getParameter("password");
              boolean role = Boolean.valueOf(request.getParameter("role"));
              
              
              if(role==true) {
              	this.getServletContext().getRequestDispatcher("/WEB-INF/HomeAdmin.jsp").forward(request, response);
              }else {
              	this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
              }
              
      		
      		Login login = new Login();
      		login.setUsername(username);
      		login.setPassword(password);
      		login.setRole(role);
      		
      		int num = MyDB.insert_login(login);
       
		
		
	}

}
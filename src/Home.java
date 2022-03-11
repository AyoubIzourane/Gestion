import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.StringUtils;

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
        	PrintWriter out = response.getWriter();

            String username = request.getParameter("username");
    		String password = request.getParameter("password");
    		
    		request.setAttribute("username", username);
    		request.setAttribute("password", password);
    		
    		
            boolean role = Boolean.valueOf(request.getParameter("role"));

            if(StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)) {
    	    	//this.getServletContext().getRequestDispatcher("/index.html").include(request, response);;
            	


            }else {
            	if(MyDB.checkAccount(username,password)) {
    				if(role==true) {
    			    	this.getServletContext().getRequestDispatcher("/WEB-INF/HomeAdmin.jsp").forward(request, response);
    			    }else {
    			    	this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    			    }
    			}
    			else {
    				out.println("<script type=\"text/javascript\">");
    	        	out.println("alert('Username or password incorrect');");
    	        	out.println("location='index.html';");
    	        	out.println("</script>");
    			}
            }
            
            
            
            
    		//insert data should be in add user
    		/*Login login = new Login();
    		login.setUsername(username);
    		login.setPassword(password);
    		login.setRole(role);
    		
    		boolean num = MyDB.insertAccount(login);*/
       
		
		
	}

}
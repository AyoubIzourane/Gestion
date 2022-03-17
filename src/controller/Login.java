package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@WebServlet(name="Login", urlPatterns="/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


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
            boolean role = Boolean.valueOf(request.getParameter("role"));
             
            //pour stocker username de l'utilisateur
            Cookie cusername = new Cookie("cusername",username);
            cusername.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cusername);

             
             
             //for connection to db DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_notes","root","");
             MyDB mydb = new MyDB();
             mydb.getConnection();
             
             try {
				User user = mydb.getUser(username);
				String fullName = user.getFull_name();
				//Cookie cfullname = new Cookie("cfullname",fullName);
				setCookie(response,"cfullname",fullName,60 * 60 * 24 * 30);
	            //cfullname.setMaxAge(60 * 60 * 24 * 30);
	            //response.addCookie(cfullname);
				//request.setAttribute("fullname", user.getFull_name());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
             
             
         
        		//role == true ==> Admin
             if(role==true) {
            	 try {
          			//calling function for connection
          			
          			//inserting login statement to check if admin exist or not 
          			Statement st = mydb.st ;
          			ResultSet rs = st.executeQuery("select * from user where username ='"+username+"' and password = '"+password+"' and role=1 ");
          			//if user exist then will show Admin Dashboard
          			if (rs.next()) {
          				
          				 this.getServletContext().getRequestDispatcher("/WEB-INF/HomeAdmin.jsp").forward(request, response);
          			}
          			else {
          				out.print("nothing");
          			}
          		} catch ( SQLException e) {
          			// TODO Auto-generated catch block
          			e.printStackTrace();
          		}
          	
            	
            	
            	
            	//role == false ==> Student
             }else {
            	 
            	 try {
            		//calling function for connection
           			
           			//inserting login statement to check if student exist or not 
           			Statement st = mydb.st ;
           			ResultSet rs = st.executeQuery("select * from user where username ='"+username+"' and password = '"+password+"' and role=0");
           			
           			//if student exist show Home page for students
           			if (rs.next()) {
           				
           				this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
           			}
           			else {
           				this.getServletContext().getRequestDispatcher("/index.html").include(request, response);

           			}
           		} catch ( SQLException e) {
           			// TODO Auto-generated catch block
           			e.printStackTrace();
           		}
           	
             	
             
             }
             
             
             
        		/*Insertion des Donnee au tableau user
        		User user = new User();
        		user.setUsername(username);
        		user.setPassword(password);
        		user.setRole(role);
        		
        		int num = MyDB.insertAccount(user);

        		 */

        	
		
	}
        
        
        
        //create cookie with space in firstname and lastname
        private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge )throws IOException { 
            Cookie cookie = new Cookie( nom, URLEncoder.encode( valeur, "UTF-8" ) );
            cookie.setMaxAge( maxAge );
            response.addCookie( cookie );
        }

}


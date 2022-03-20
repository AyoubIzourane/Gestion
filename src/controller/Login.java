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
import javax.servlet.http.HttpSession;

import model.Student;
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
        	//for connection to db DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_notes","root","");
             
        	PrintWriter out = response.getWriter();
        	String username = request.getParameter("username");
        	String password = request.getParameter("password");
            boolean role = Boolean.valueOf(request.getParameter("role"));
             
            /*pour stocker username de l'utilisateur
            Cookie cusername = new Cookie("cusername",username);
            cusername.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cusername);*/
            
            
            
             
             CRUDOperations crud = new CRUDOperations();
            	 Student student = new Student();
            	 student.setGenre("f");
                 student.setClasse("gi");
            	 
                 out.print("before");
            	 crud.insertEntity(student);
                 System.out.print("after");

            crud.findEntity();
            System.out.print("show");
             
             
             
        		/*Insertion des Donnee au tableau user
        		User user = new User();
        		user.setUsername(username);
        		user.setPassword(password);
        		user.setRole(role);
        		
        		int num = MyDB.insertAccount(user);

        		 */
            
        	this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);


        	
		
	}
        
        
        
        //create cookie with space in firstname and lastname
        private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge )throws IOException { 
            Cookie cookie = new Cookie( nom, URLEncoder.encode( valeur, "UTF-8" ) );
            cookie.setMaxAge( maxAge );
            response.addCookie( cookie );
        }

}


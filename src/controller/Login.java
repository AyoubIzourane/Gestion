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

import model.Person;
import model.User;

@WebServlet(name="Login", urlPatterns="/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	//this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
        	
        	PrintWriter out = response.getWriter();
        	String username = request.getParameter("username");
        	String password = request.getParameter("password");
        	
        	MyDB mydb = new MyDB();
            mydb.getConnection();
            
            try {
				Person person = mydb.getPerson(username);
				String fName = person.getFname();
				String lName = person.getLname();
				//Cookie cfullname = new Cookie("cfullname",fullName);
				Cookie cfName = new Cookie("cfname",fName);
				cfName.setMaxAge(60 * 60 * 24 * 30);
				Cookie clName = new Cookie("clname",lName);
				clName.setMaxAge(60 * 60 * 24 * 30);
				response.addCookie(cfName);
				response.addCookie(clName);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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

            MyDB mydb = new MyDB();
            mydb.getConnection();
            
            try {
				Person person = mydb.getPerson(username);
				String fName = person.getFname();
				String lName = person.getLname();
				//Cookie cfullname = new Cookie("cfullname",fullName);
				Cookie cfName = new Cookie("cfname",fName);
				cfName.setMaxAge(60 * 60 * 24 * 30);
				Cookie clName = new Cookie("clname",lName);
				clName.setMaxAge(60 * 60 * 24 * 30);
				response.addCookie(cfName);
				response.addCookie(clName);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
             
             //for connection to db DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_notes","root","");
             
             System.out.print(role);
             if(role==true) {
            	 if(MyDB.checkAccountAdmin(username, password)) {
      				 this.getServletContext().getRequestDispatcher("/WEB-INF/HomeAdmin.jsp").forward(request, response);
            	 }else {
            		 out.println("<h1>error</h1>");
      				 this.getServletContext().getRequestDispatcher("/index.html").include(request, response);
            	 }
             }else {
            	 if(MyDB.checkAccount(username, password)) {
      				 this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
            	 }else {
      				 this.getServletContext().getRequestDispatcher("/index.html").include(request, response);
            	 }
             }
             
         
	}
        

	
}
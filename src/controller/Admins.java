package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDaoImp;
import model.Person;

/**
 * Servlet implementation class Modules
 */
@WebServlet(name="Admins", urlPatterns={"/Admins","/insertAdmin","/updateAdmin","/deleteAdmin"})
public class Admins extends HttpServlet{
      @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Person person = new Person();
    	 AdminDaoImp admindaoimp = new AdminDaoImp();
      	
      	
      	
      	String path=request.getServletPath();
      	
      	System.out.println("PATH "+path);
      	if (path.equals("/Admins"))
      	{
      		
   
      	}
      	
      	else if (path.equals("/insertAdmin"))
      	{
      		String firstname = request.getParameter("firstname");
      		String lastname = request.getParameter("lastname");
          	String username = request.getParameter("username");
          	String password = request.getParameter("password");
          	String email = request.getParameter("email");
          	String phone = request.getParameter("phone");
         
          	
          	
          	person.setFname(firstname);
          	person.setLname(lastname);
          	person.setUsername(username);
          	person.setPassword(password);
          	person.setEmail(email);
          	person.setPhone(phone);
          	
      		admindaoimp.insertEntity(person);
      		RequestDispatcher dd=request.getRequestDispatcher("Admins");
      		dd.forward(request, response);
      	}
      	
      	
     
      	
      	else if (path.equals("/updateAdmin"))
      	{
 
      		
      		
          	
      		RequestDispatcher dd=request.getRequestDispatcher("Admins");
      		dd.forward(request, response);
      
      	}
      	
      	else if (path.equals("/deleteAdmin"))
      	{
      		int id= Integer.parseInt(request.getParameter("id_person"));
      		admindaoimp.removeEntity(id);
      	
      		RequestDispatcher dd=request.getRequestDispatcher("Admins");
      		dd.forward(request, response);
      
      	}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admins.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

    
}
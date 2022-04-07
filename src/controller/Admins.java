package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDaoImp;
import model.Person;

/**
 * Servlet implementation class Modules
 */
@WebServlet(name="Admins", urlPatterns={"/Admins","/insertAdmin","/deleteAdmin","/editAdmin"})
public class Admins extends HttpServlet{
      @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Person person = new Person();
    	 AdminDaoImp admindaoimp = new AdminDaoImp();
      	
      	
      	
      	String path=request.getServletPath();
  		request.setAttribute("cle", 0);

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
      		request.setAttribute("cle", 0);

      		admindaoimp.insertEntity(person);
      		RequestDispatcher dd=request.getRequestDispatcher("Admins");
      		dd.forward(request, response);
      	}
      	
      	
      	else if (path.equals("/deleteAdmin"))
      	{
      		int id= Integer.parseInt(request.getParameter("id_person"));
      		admindaoimp.removeEntity(id);
      	System.out.println(id);
  		request.setAttribute("cle", 0);

      		RequestDispatcher dd=request.getRequestDispatcher("Admins");
      		dd.forward(request, response);
      
      	}
      	
      	else if (path.equals("/editAdmin"))
      	{
      		int id= Integer.parseInt(request.getParameter("id_person"));
      		person = admindaoimp.findEntity(id);
      		
      		int cle =1;
      		request.setAttribute("admin", person);
      		request.setAttribute("cle", cle);
      		
      		HttpSession session = request.getSession();
      		session.setAttribute("id_admin", id);

      	}

      	
      	
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admins.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
          		request.setAttribute("cle", 0);

          		admindaoimp.insertEntity(person);
          		RequestDispatcher dd=request.getRequestDispatcher("Admins");
          		dd.forward(request, response);
          	}
        	
        	else if (path.equals("/editAdmin"))
          	{
        		
          		HttpSession session = request.getSession();
          		int id = (int) session.getAttribute("id_admin");

          		System.out.println(id);
          		
        		String firstname = request.getParameter("firstname");
          		String lastname = request.getParameter("lastname");
              	String username = request.getParameter("username");
              	String password = request.getParameter("password");
              	String email = request.getParameter("email");
              	String phone = request.getParameter("phone");
             
              	person.setId_person(id);
              	person.setFname(firstname);
              	person.setLname(lastname);
              	person.setUsername(username);
              	person.setPassword(password);
              	person.setEmail(email);
              	person.setPhone(phone);
          		request.setAttribute("cle", 0);

          		admindaoimp.updateEntity(person);
          		Person p = new Person();
          		request.setAttribute("admin", p);
          		
          		
          		System.out.println("update done" );
          		

          	}
         	
         	
    		this.getServletContext().getRequestDispatcher("/WEB-INF/Admins.jsp").forward(request, response);

	}

    
}
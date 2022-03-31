package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ModuleAdminDaoImp;
import model.Module;

/**
 * Servlet implementation class Modules
 */
@WebServlet(name="ModuleAdmin", urlPatterns={"/ModuleAdmin","/insertModule","/updateModule","/deleteModule"})
public class ModuleAdmin extends HttpServlet{
      @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Module module = new Module();
    	 ModuleAdminDaoImp moduleadmindaoimp = new ModuleAdminDaoImp();
      	
      	
      	
      	String path=request.getServletPath();
      	
      	System.out.println("PATH "+path);
      	if (path.equals("/ModuleAdmin"))
      	{
      		
   
      	}
      	
      	else if (path.equals("/insertModule"))
      	{
      		String subjectname = request.getParameter("subjectname");
      		int subjectnum = Integer.parseInt(request.getParameter("subjectnum"));
      		String teachername = request.getParameter("teachername");
      		
         
          	
          	
          	module.setModule_name(subjectname);
          	module.setModule_num(subjectnum);
          	module.setTeacher_name(teachername);
          	
          	
      		moduleadmindaoimp.insertEntity(module);
      		RequestDispatcher dd=request.getRequestDispatcher("ModuleAdmin");
      		dd.forward(request, response);
      	}
      	
      	
     
      	
      	else if (path.equals("/updateModule"))
      	{
 
      		
      		
          	
      		RequestDispatcher dd=request.getRequestDispatcher("ModuleAdmin");
      		dd.forward(request, response);
      
      	}
      	
      	else if (path.equals("/deleteModule"))
      	{
      		int id= Integer.parseInt(request.getParameter("id_module"));
      		moduleadmindaoimp.removeEntity(id);
      	System.out.println(id);
      		RequestDispatcher dd=request.getRequestDispatcher("ModuleAdmin");
      		dd.forward(request, response);
      
      	}
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModuleAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

    
}
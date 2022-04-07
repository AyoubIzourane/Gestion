package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ModuleAdminDaoImp;
import model.Module;

/**
 * Servlet implementation class Modules
 */
@WebServlet(name="ModuleAdmin", urlPatterns={"/ModuleAdmin","/insertModule","/editModule","/deleteModule"})
public class ModuleAdmin extends HttpServlet{
      @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Module module = new Module();
    	 ModuleAdminDaoImp moduleadmindaoimp = new ModuleAdminDaoImp();
      	
      	
      	
      	String path=request.getServletPath();
      	
      	System.out.println("PATH "+path);
      	if (path.equals("/ModuleAdmin"))
      	{
      		
     		request.setAttribute("cle", 0);

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
      	
      	
     
      	
      	else if (path.equals("/editModule"))
      	{
      		
      		int id = Integer.parseInt(request.getParameter("id_module"));
      		
      		module = moduleadmindaoimp.findEntity(id);
      		
      		request.setAttribute("m", module);

      		int cle =1;
      		request.setAttribute("cle", cle);
      		
      		HttpSession session = request.getSession();
      		session.setAttribute("idmodule", id);
      		
      	}
      	
      	else if (path.equals("/deleteModule"))
      	{
      		int id= Integer.parseInt(request.getParameter("id_module"));
      		moduleadmindaoimp.removeEntity(id);
      	System.out.println(id);
      	
 		request.setAttribute("cle", 0);

      	
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
             	
         		request.setAttribute("cle", 0);

             	
         		moduleadmindaoimp.insertEntity(module);
         		RequestDispatcher dd=request.getRequestDispatcher("ModuleAdmin");
         		dd.forward(request, response);
         	}
         	
         	
        
         	
         	else if (path.equals("/editModule"))
         	{
         		HttpSession session = request.getSession();
         		int id = (int) session.getAttribute("idmodule");
         		
         		String subjectname = request.getParameter("subjectname");
         		int subjectnum = Integer.parseInt(request.getParameter("subjectnum"));
         		String teachername = request.getParameter("teachername");
         		
         		module.setId_module(id);
         		module.setModule_name(subjectname);
         		module.setModule_num(subjectnum);
         		module.setTeacher_name(teachername);

         		moduleadmindaoimp.updateEntity(module);
         		
         		Module m = new Module();
         		request.setAttribute("m", m);

         		request.setAttribute("cle", 0);
         		
         		
         	}
         	
         	
    		this.getServletContext().getRequestDispatcher("/WEB-INF/ModuleAdmin.jsp").forward(request, response);

	}

    
}
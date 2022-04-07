package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ModuleAdminDaoImp;
import dao.NoteDaoImp;
import dao.StudentDaoImp;
import model.Note;
import model.NoteId;
import model.Person;
import model.Student;

@WebServlet(name="Notes", urlPatterns={"/Notes","/insertNote","/deleteNote","/editNote","/editN"})
public class Notes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Note note = new Note();
		NoteDaoImp noteDao = new NoteDaoImp(); 
		NoteId noteId = new NoteId();
      	String path=request.getServletPath();
      	System.out.println("PATH "+path);

      	if (path.equals("/Notes"))
      	{
      		
   
      	}
      	
      	else if (path.equals("/insertNote"))
      	{
      		int id_person = Integer.parseInt(request.getParameter("id_person"));
      		int id_module = Integer.parseInt(request.getParameter("id_module"));
      		String student_name = request.getParameter("student_name");
      		String module_name = request.getParameter("module_name");
      		String exam_date = request.getParameter("date");
      		float n = Float.parseFloat(request.getParameter("note"));
      		
      		noteId.setId_person(id_person);
      		noteId.setId_module(id_module);
      		note.setId(noteId);
      		
      		note.setExam_date(exam_date);
      		note.setNote(n);
      		
      		System.out.println(note.getId().getId_person());
      		System.out.println(note.getId().getId_module());
      		System.out.println(note.getExam_date());
      		System.out.println(note.getNote());
      		
      		noteDao.insertEntity(note);
      		
      		request.setAttribute("cle",0);

    		this.getServletContext().getRequestDispatcher("/WEB-INF/Notes.jsp").forward(request, response);

      	}
      	
      	else if (path.equals("/deleteNote")) {
      		int id_person = Integer.parseInt(request.getParameter("id_person"));
      		int id_module = Integer.parseInt(request.getParameter("id_module"));
      		
      		
      		noteId.setId_person(id_person);
      		noteId.setId_module(id_module);
      		
      		note.setId(noteId);
      		System.out.println(noteId);

      		noteDao.removeEntity(noteId);
      		request.setAttribute("cle",0);

    		this.getServletContext().getRequestDispatcher("/WEB-INF/Notes.jsp").forward(request, response);
      	}
      	
      	else if (path.equals("/editNote")) {
      		int id_person = Integer.parseInt(request.getParameter("id_person"));
      		int id_module = Integer.parseInt(request.getParameter("id_module"));
      		
      		noteId.setId_person(id_person);
      		noteId.setId_module(id_module);
      		note = noteDao.findEntity(noteId);
      		
      		Student s = new Student();
      		StudentDaoImp sdao = new StudentDaoImp();
      		
      		
      		s = sdao.findEntity(id_person);
      		
      		ModuleAdminDaoImp mdao = new ModuleAdminDaoImp();
      		System.out.print("id : "+s.getId_person());
      		int i=1;
      		request.setAttribute("ed_note",note);
      		request.setAttribute("student",s);
      		request.setAttribute("idperson",s.getId_person());
      		request.setAttribute("module",mdao.findEntity(id_module));
      		request.setAttribute("cle",i);
      		
    		this.getServletContext().getRequestDispatcher("/WEB-INF/Notes.jsp").forward(request, response);
      	}
      	
      	
  		request.setAttribute("cle",0);

		this.getServletContext().getRequestDispatcher("/WEB-INF/Notes.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Note note = new Note();
		NoteDaoImp noteDao = new NoteDaoImp(); 
		NoteId noteId = new NoteId();
      	String path=request.getServletPath();      	
      	
      	

      	if (path.equals("/Notes"))
      	{
      		
   
      	}
      	else if (path.equals("/insertNote"))
      	{
      		int id_person = Integer.parseInt(request.getParameter("id_person"));
      		int id_module = Integer.parseInt(request.getParameter("id_module"));
      		String student_name = request.getParameter("student_name");
      		String module_name = request.getParameter("module_name");
      		String exam_date = request.getParameter("date");
      		float n = Float.parseFloat(request.getParameter("note"));
      		
      		noteId.setId_person(id_person);
      		noteId.setId_module(id_module);
      		note.setId(noteId);
      		
      		note.setExam_date(exam_date);
      		note.setNote(n);
      		
      		System.out.println(note.getId().getId_person());
      		System.out.println(note.getId().getId_module());
      		System.out.println(note.getExam_date());
      		System.out.println(note.getNote());
      		
      		noteDao.insertEntity(note);
      		
      		request.setAttribute("cle",0);
    		this.getServletContext().getRequestDispatcher("/WEB-INF/Notes.jsp").forward(request, response);

      	}
      	else if (path.equals("/editN")) {
      		int id_person = Integer.parseInt(request.getParameter("id_person"));
      		int id_module = Integer.parseInt(request.getParameter("id_module"));
      		String exam_date = request.getParameter("date");
      		float n = Float.parseFloat(request.getParameter("note"));
      		
      		noteId.setId_person(id_person);
      		noteId.setId_module(id_module);
      		note.setId(noteId);

      		note.setExam_date(exam_date);
      		note.setNote(n);
      		note.setId(noteId);
      		System.out.println(noteId);

      		noteDao.updateEntity(note);
      		noteId.setId_person(id_person);
      		noteId.setId_module(id_module);
      		note = noteDao.findEntity(noteId);
      		
      		
      		int i=0;
      		Note note2 = new Note();
      		request.setAttribute("ed_note",note2);
      		request.setAttribute("cle",i);
      		
    		this.getServletContext().getRequestDispatcher("/WEB-INF/Notes.jsp").forward(request, response);
      	}
      	
	}

}
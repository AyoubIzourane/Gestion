package model;

import java.util.Set;


public class Student{
	
	private static int id_student;
	private String genre;
	private String classe;
	Set<Note> note;
	
	public static int getId_student() {
		return id_student;
	}
	public static void setId_student(int id_student) {
		Student.id_student = id_student;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public Set<Note> getNote() {
		return note;
	}
	public void setNote(Set<Note> note) {
		this.note = note;
	}
	

}

package model;



public class Note {
	private static int id_note;
	private float note;
	private String exam_date;
	private Student student;
	private Module module;
	
	public static int getId_note() {
		return id_note;
	}
	public static void setId_note(int id_note) {
		Note.id_note = id_note;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
}

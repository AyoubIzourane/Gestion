package dao;

import model.Student;

public interface StudentDao {
	public void insertEntity(Student student);
	public Student findEntity(int id);
	 public void updateEntity(Student student) ;
	 public void removeEntity(int id);
}

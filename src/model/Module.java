package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Module implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_module")
	private int id_module;
	
	@Column(name="module_name")
	private String module_name;
	
	@Column(name="module_num")
	private int module_num; 
	
	@Column(name="teacher_name")
	private String teacher_name;
	
	@ManyToMany
	@JoinTable(
			  name = "student_module", 
			  joinColumns = @JoinColumn(name = "id_module"), 
			  inverseJoinColumns = @JoinColumn(name = "id_person"))
	private List<Student> student = new ArrayList<>();

	
	public int getId_module() {
		return id_module;
	}
	public void setId_module(int id_module) {
		this.id_module = id_module;
	}
	
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	
	
	
	
	public int getModule_num() {
		return module_num;
	}
	public void setModule_num(int module_num) {
		this.module_num = module_num;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Module [id_module=" + id_module + ", module_name=" + module_name + ", module_num=" + module_num
				+ ", teacher_name=" + teacher_name + ", student=" + student + ", getId_module()=" + getId_module()
				+ ", getModule_name()=" + getModule_name() + ", getModule_num()=" + getModule_num()
				+ ", getTeacher_name()=" + getTeacher_name() + ", getStudent()=" + getStudent() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}

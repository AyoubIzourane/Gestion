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
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Module [id_module=" + id_module + ", module_name=" + module_name + "]";
	}
	
}

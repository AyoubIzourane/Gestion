package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("S")
public class Student extends Person{
	
	@Column(name="genre")
	private String genre;
	@Column(name="classe")
	private String classe;
	
	
	@ManyToMany
	@JoinTable(
			  name = "student_module", 
			  joinColumns = @JoinColumn(name = "id_person"), 
			  inverseJoinColumns = @JoinColumn(name = "id_module"))
	private List<Module> module = new ArrayList<>();
	
	public Student() {
		
	}
	
	public Student(String genre, String classe) {
		super();
		this.genre = genre;
		this.classe = classe;
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
	public List<Module> getModule() {
		return module;
	}
	public void setModule(List<Module> module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "Student [genre=" + genre + ", classe=" + classe + ", module=" + module + ", getGenre()=" + getGenre()
				+ ", getClasse()=" + getClasse() + ", getModule()=" + getModule() + ", getId_user()=" + getId_user()
				+ ", getFname()=" + getFname() + ", getLname()=" + getLname() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone()
				+ ", isRole()=" + isRole() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
	
}

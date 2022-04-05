package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NoteId implements Serializable{
    @Column(name = "id_person")
	private int id_person;
    @Column(name = "id_module")
	private int id_module;
	
	public int getId_person() {
		return id_person;
	}

	public void setId_person(int id_person) {
		this.id_person = id_person;
	}

	public int getId_module() {
		return id_module;
	}

	public void setId_module(int id_module) {
		this.id_module = id_module;
	}

	public int hashCode() {
		return (int)(id_person + id_module);
	}

	public boolean equals(Object object) {
		if (object instanceof NoteId) {
			NoteId otherId = (NoteId) object;
		      return (otherId.id_person == this.id_person) 
		              && (otherId.id_module == this.id_module);
		    }
		    return false;
		}

}

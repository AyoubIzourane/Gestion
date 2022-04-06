package model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="student_module")
public class Note implements Serializable{
	
	@EmbeddedId
     NoteId id = new NoteId();
	
	private float note;
	private String exam_date;
	
	
	public NoteId getId() {
		return id;
	}
	public void setId(NoteId id) {
		this.id = id;
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
	
}

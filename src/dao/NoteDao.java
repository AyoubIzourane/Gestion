package dao;

import model.Note;
import model.NoteId;

public interface NoteDao {
	public void insertEntity(Note note);
	public Note findEntity(NoteId id);
	 public void updateEntity(Note note) ;
	 public void removeEntity(NoteId id);
}

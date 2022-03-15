package model;

import java.util.Set;



public class Module {
	
	private static int id_module;
	private String name;
	
	Set<Note> note;
	
	public static int getId_module() {
		return id_module;
	}
	public static void setId_module(int id_module) {
		Module.id_module = id_module;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Note> getNote() {
		return note;
	}
	public void setNote(Set<Note> note) {
		this.note = note;
	}
	
}

package dao;

import model.Person;


public interface AdminDao {
	public void insertEntity(Person person);
	 public void findEntity();
	 public void updateEntity(Person person) ;
	 public void removeEntity(int id);
}
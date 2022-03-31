package dao;

import model.Module;


public interface ModuleAdminDao {
	public void insertEntity(Module module);
	public Module findEntity(int id);
	 public void updateEntity(Module module) ;
	 public void removeEntity(int id);
}
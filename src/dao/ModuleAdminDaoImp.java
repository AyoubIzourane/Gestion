package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Entity;

import model.Module;
import util.JPAutil;


public class ModuleAdminDaoImp implements ModuleAdminDao{
	public void insertEntity(Module module) {
		EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(module);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

	public Module findEntity(int id) {
        EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Module module = entityManager.find(Module.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return module;
    }

    public void updateEntity(Module m) {
        EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        

       
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(m);
        tx.commit();
        
        
    }

    public void removeEntity(int id) {
        EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();


        Module module = entityManager.find(Module.class, id);
    
    
        entityManager.getTransaction().begin();
        entityManager.remove(module);
        entityManager.getTransaction().commit();
        
    }


}
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Entity;

import model.Person;
import util.JPAutil;


public class AdminDaoImp implements AdminDao{
	public void insertEntity(Person person) {
		EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void findEntity() {
        EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Person person= entityManager.find(Person.class, 1);
       
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEntity(Person p) {
        EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        

       
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(p);
        tx.commit();
        
        
    }

    public void removeEntity(int id) {
        EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();


        Person person = entityManager.find(Person.class, id);
    
    
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        entityManager.getTransaction().commit();
        
    }


}
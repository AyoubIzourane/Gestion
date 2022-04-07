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

	public Person findEntity(int id) {
        EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person person = entityManager.find(Person.class, id);
        entityTransaction.commit();
        entityManager.close();
        return person;
    }

    public void updateEntity(Person p) {
    	EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(p);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        
    }

    public void removeEntity(int id) {
        EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();


        Person person = entityManager.find(Person.class, id);
    
    
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        entityManager.getTransaction().commit();
        
    }


}
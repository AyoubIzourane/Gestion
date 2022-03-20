package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Person;
import model.Student;
import util.JPAutil;

public class StudentDaoImp implements StudentDao {

	@Override
	public void insertEntity(Student student) {
		EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
		
	}

	@Override
	public Student findEntity(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEntity(int id) {
		 EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();


	        Person person = entityManager.find(Person.class, id);
	    
	    
	        entityManager.getTransaction().begin();
	        entityManager.remove(person);
	        entityManager.getTransaction().commit();
		
	}

}

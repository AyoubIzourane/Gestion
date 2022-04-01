package dao;

import java.util.ArrayList;
import java.util.List;

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
		Student student = new Student();
		EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        student = entityManager.find(Student.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return student;
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
	
	public List<Module> getModules(int id){
		EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
		List<Module> modules = 
				entityManager.createQuery("select m from Student s join s.module m where s.id_person = "+id).getResultList();
		
		return modules;
		
	}

}

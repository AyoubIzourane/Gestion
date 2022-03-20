package controller;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import model.Student;
public class CRUDOperations {
	private EntityManager entityManager=JPAUtil.getEntityManager("Gestion");
	
    public void insertEntity(Student student){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void findEntity() {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, 1);
        System.out.println("student id :: " + student.getId_user());
        System.out.println("student firstname :: " + student.getFname());
        System.out.println("student lastname :: " + student.getLname());
        System.out.println("student email :: " + student.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEntity() {
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, 1);
        System.out.println("student id :: " + student.getId_user());
        System.out.println("student firstname :: " + student.getFname());
        System.out.println("student lastname :: " + student.getLname());
        System.out.println("student email :: " + student.getEmail());

        // The entity object is physically updated in the database when the transaction
        // is committed
        student.setFname("youssef2");
        student.setLname("el goumri2");
        student.setEmail("youssef2@gmail.com");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntity() {
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, 1);
        System.out.println("student id :: " + student.getId_user());
        System.out.println("student firstname :: " + student.getFname());
        System.out.println("student lastname :: " + student.getLname());
        System.out.println("student email :: " + student.getEmail());
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
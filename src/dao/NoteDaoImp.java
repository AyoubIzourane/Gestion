package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Note;
import model.NoteId;
import util.JPAutil;

public class NoteDaoImp implements NoteDao{
	@Override
	public void insertEntity(Note note) {
		EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(note);
        entityManager.getTransaction().commit();
        entityManager.close();
		
	}
	
	@Override
	public Note findEntity(NoteId id) {
		Note note = new Note();
		EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        note = entityManager.find(Note.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return note;
	}

	@Override
	public void updateEntity(Note note) {
		EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(note);
        entityManager.getTransaction().commit();
        entityManager.close();
	}

	@Override
	public void removeEntity(NoteId id) {
		EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();


        Note note = entityManager.find(Note.class, id);
    
    
        entityManager.getTransaction().begin();
        entityManager.remove(note);
        entityManager.getTransaction().commit();		
	}
}

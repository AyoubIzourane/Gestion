package controller;

import model.User;
import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserJpaController implements Serializable {

    private EntityManager em;
    private EntityManagerFactory emf;

    public UserJpaController() throws Exception {
        emf = Persistence.createEntityManagerFactory("Gestion");
    }
    
    public void create(User user) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public User login(String username, String password) {
        em = emf.createEntityManager();
        Query q = em.createQuery("SELECT a from person a where a.username = :user AND a.pass = :pass ");
        q.setParameter("user", username);
        q.setParameter("pass", password);

        List<User> ls = q.getResultList();

        if (ls.size() == 1) {
            return ls.get(0);
        }
        return null;
    }
}
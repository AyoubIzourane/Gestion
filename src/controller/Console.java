package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Student;
import model.Module;

public class Console {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        
        try {
            
            entityManagerFactory = Persistence.createEntityManagerFactory("Gestion");
            entityManager = entityManagerFactory.createEntityManager();
        
            Student student = entityManager.find( Student.class, 1 );            
            System.out.println( student.getFname() + "'s Modules" );
            for( Module associatedModule : student.getModule() ) {
                System.out.println( associatedModule );
            }

            Module module = entityManager.find( Module.class, 1 );            
            System.out.println( module.getModule_name() + "'s Students" );
            for( Student associatedStudent : module.getStudent() ) {
                System.out.println( associatedStudent );
            }


        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }

    }
}
package main.java.com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyEntityManagerFactory {

    private static EntityManager em;


    public static EntityManager getEntityManager() {

        if (em == null) {
            EntityManagerFactory emf =  Persistence.createEntityManagerFactory("MusicAlbumsPU");
            em = emf.createEntityManager();
        }
        return em;
    }

    public static void closeEntityManager() {
        if (em != null) {
            em.close();
        }
    }

    public static void createEntityManagerFactory() {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("MusicAlbumsPU");
        em = emf.createEntityManager();
    }


}

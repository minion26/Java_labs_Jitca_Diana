package main.java.com.example;

import jakarta.persistence.*;

public class MyEntityManagerFactory {

    private static EntityManager em;
    private static EntityManagerFactory emf;


    public static EntityManager getEntityManager() {

        if (em == null) {
            emf =  Persistence.createEntityManagerFactory("MusicAlbumsPU");
            em = emf.createEntityManager();
        }
        return em;
    }

    public static void closeEntityManager() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    public static void createEntityManagerFactory() {
        emf =  Persistence.createEntityManagerFactory("MusicAlbumsPU");
        em = emf.createEntityManager();
    }


}

package main.java.com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        MyEntityManagerFactory.createEntityManagerFactory();
        EntityManager em = MyEntityManagerFactory.getEntityManager();

        em.getTransaction().begin();

        AlbumsRepo albumsRepo = new AlbumsRepo(em);
        albumsRepo.findAll().forEach(System.out::println);

        GenreRepo genreRepo = new GenreRepo(em);
        GenreEntity genre = new GenreEntity();
        //genre.setName("DianaJitca11111");
        //genreRepo.create(genre);
        System.out.println("The new genre: " + genreRepo.findByName("DianaJitca"));

        ArtistRepo artistRepo = new ArtistRepo(em);
        System.out.println("The id is : " + artistRepo.findByName("The Beatles").getId());

        em.getTransaction().commit();
        em.getEntityManagerFactory().close();
        em.close();

    }
}

package main.java.com.example;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GenreRepo {
    private EntityManager em;

    public GenreRepo(EntityManager em) {
        this.em = em;
    }

    public void create(GenreEntity genre) {
        em.persist(genre);
    }
    public GenreEntity findByName(String name) {
        return em.createNamedQuery("Genre.findByName", GenreEntity.class)
                .setParameter("name", name)
                .getSingleResult();
    }
    public List<GenreEntity> findAll() {
        return em.createNamedQuery("Genre.findAll", GenreEntity.class)
                .getResultList();
    }

    public GenreEntity findById(Integer id){
        return em.createNamedQuery("Genre.findById", GenreEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}

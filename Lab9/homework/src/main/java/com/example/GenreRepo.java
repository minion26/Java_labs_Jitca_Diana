package main.java.com.example;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GenreRepo extends AbstractRepository<GenreEntity>{
   /* private EntityManager em;

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
        return em.find(GenreEntity.class, id);
    }*/

    public GenreRepo(EntityManager entityManager, Class<GenreEntity> entityClass) {
        super(entityManager, entityClass);
    }


}

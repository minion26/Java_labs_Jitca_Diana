package main.java.com.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class AlbumsRepo extends AbstractRepository<AlbumsEntity>{
    /*private EntityManager em; //create it somehow

    public AlbumsRepo(EntityManager em) {
        this.em = em;
    }


    public List<AlbumsEntity> findAll() {
        return em.createNamedQuery("Albums.findAll", AlbumsEntity.class)
                .getResultList();
    }

    public void create(AlbumsEntity album) {
        em.persist(album);
    }

    public AlbumsEntity findById(int id) {
        return em.find(AlbumsEntity.class, id);
    }*/

    public AlbumsRepo (EntityManager entityManager, Class<AlbumsEntity> entityClass) {
        super(entityManager, entityClass);
    }
}

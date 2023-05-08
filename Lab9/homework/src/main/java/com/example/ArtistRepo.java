package main.java.com.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class ArtistRepo extends AbstractRepository<ArtistEntity> {
    /*private EntityManager em;

    //create it
    public ArtistRepo(EntityManager em) {
        this.em = em;
    }


    //insert into Artist(name) values('Test')
    public void create(String name) {
        ArtistEntity artist = new ArtistEntity();
        artist.setName(name);
        em.persist(artist);
    }


    public ArtistEntity findByName(String name) {
        return (ArtistEntity) em.createNamedQuery("Artist.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<ArtistEntity> findAll() {
        return em.createNamedQuery("Artist.findAll", ArtistEntity.class)
                .getResultList();
    }

    public ArtistEntity findById(int id) {
        return em.find(ArtistEntity.class, id);
    }*/

    public ArtistRepo(EntityManager entityManager, Class<ArtistEntity> entityClass) {
        super(entityManager, entityClass);
    }


}

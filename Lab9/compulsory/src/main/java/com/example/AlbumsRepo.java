package main.java.com.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class AlbumsRepo {
    private EntityManager em; //create it somehow

    public AlbumsRepo(EntityManager em) {
        this.em = em;
    }

    public AlbumsEntity findByArtist(ArtistEntity artist) {
        return (AlbumsEntity) em.createNamedQuery("Albums.findByArtist")
                .setParameter("artist", artist)
                .getSingleResult();
    }

    public List<AlbumsEntity> findAll() {
        return em.createNamedQuery("Albums.findAll")
                .getResultList();
    }

    public void create(AlbumsEntity album) {
        em.persist(album);
    }

    public AlbumsEntity findById(int id) {
        return (AlbumsEntity) em.createNamedQuery("Albums.findById")
                .setParameter("id", id)
                .getSingleResult();
    }
}

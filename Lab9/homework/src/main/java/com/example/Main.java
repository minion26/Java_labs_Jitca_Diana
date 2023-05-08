package main.java.com.example;

import com.github.javafaker.Faker;
import com.google.common.base.Stopwatch;
import jakarta.persistence.*;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main {
    public static void main(String[] args) {

        MyEntityManagerFactory.createEntityManagerFactory();
        EntityManager em = MyEntityManagerFactory.getEntityManager();

        em.getTransaction().begin();

        ArtistRepo artistRepo = new ArtistRepo(em, ArtistEntity.class);
        GenreRepo genreRepo = new GenreRepo(em, GenreEntity.class);
        AlbumsRepo albumsRepo = new AlbumsRepo(em, AlbumsEntity.class);

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {
            fh = new FileHandler("C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\demo\\log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info("Log created");

            Faker faker = new Faker();
            Stopwatch timer = Stopwatch.createStarted();
            //create 10 artists
            for (int i = 0; i < 10; i++) {
                //create artist
                ArtistEntity artistEntity = new ArtistEntity();
                artistEntity.setName(faker.gameOfThrones().character());
                //what if the artist already exists in the db?
                //check if artist exists in db
                if (!artistRepo.exists(artistEntity.getName())) {
                    artistRepo.create(artistEntity);
                    logger.info("Artist " +artistEntity.getName() +" created");
                } else {
                    logger.info("Artist " + artistEntity.getName()+ " already exists");
                    artistEntity = artistRepo.findByName(artistEntity.getName());
                }

                for (int j = 0; j < 3; j++) {
                    //create genre
                    GenreEntity genreEntity = new GenreEntity();
                    genreEntity.setName(faker.music().genre());
                    //if the genre already exists in the db, use it
                    if (genreRepo.exists(genreEntity.getName())) {
                        genreEntity = genreRepo.findByName(genreEntity.getName());
                        logger.info("Genre " + genreEntity.getName() + " created");
                    } else
                        genreRepo.create(genreEntity);//save genre to db for obtaining the id


                    //create album

                    AlbumsEntity albumsEntity = new AlbumsEntity();
                    albumsEntity.setArtist(artistEntity);
                    albumsEntity.setGenres(genreEntity);

                    albumsEntity.setReleaseYear(faker.number().digits(4));

                    //the title must be unique
                    String title = faker.gameOfThrones().house();
                    if (albumsRepo.existsTitle(title)) {
                       logger.info("Album " + title+ " already exists");
                        albumsEntity = albumsRepo.findByTitle(title);
                    } else
                        albumsEntity.setTitle(title);

                    albumsRepo.create(albumsEntity);
                    logger.info("Album created");
                }
            }
            timer.stop();
            logger.info("Time elapsed: " + timer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        em.getTransaction().commit();
        em.getEntityManagerFactory().close();
        em.close();

    }
}

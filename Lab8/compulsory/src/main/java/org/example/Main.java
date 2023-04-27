package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{

            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            artists.create("Queen");
            artists.create("The Beatles");

            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk,Soul,Pop");
            genres.create("Progressive Rock");
            genres.create("Hard Rock");
            var albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            //findByName
            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
            albums.create(1975, "A Night at the Opera", "Queen", "Rock");
            System.out.println(albums.findByTitle("The Wall"));
            DataBase.getConnection().commit();
            DataBase.closeConnection();



    }

}

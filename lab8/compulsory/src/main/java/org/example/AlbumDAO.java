package org.example;

import java.sql.*;


public class AlbumDAO {


    public void create(Integer releaseYear, String title, String artist, String genre) throws SQLException {
        Connection con = DataBase.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist_id, genre_id) values (?, ?, ?, ?)")) {
            pstmt.setInt(1, releaseYear);
            pstmt.setString(2, title);
            pstmt.setInt(3, new ArtistDAO().findByName(artist));
            pstmt.setInt(4, new GenreDAO().findByName(genre));
            pstmt.executeUpdate();
            con.commit();
        }
    }

    public Integer findByTitle(String title) throws SQLException {
        Connection con = DataBase.getConnection();
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "select id from albums where title='" + title + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = DataBase.getConnection();
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "select name from albums where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public String findByArtist(String artist) throws SQLException {
        Connection con = DataBase.getConnection();
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "select name from albums where artist_id=" + new ArtistDAO().findByName(artist))) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public Integer findByRelaseYear(Integer releaseYear) throws SQLException {
        Connection con = DataBase.getConnection();
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "select id from albums where release_year=" + releaseYear)) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findByGenre(String genre) throws SQLException {
        Connection con = DataBase.getConnection();
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "select name from albums where genre_id=" + new GenreDAO().findByName(genre))) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

}

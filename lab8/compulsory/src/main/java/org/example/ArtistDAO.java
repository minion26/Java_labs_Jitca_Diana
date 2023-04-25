package org.example;

import java.sql.*;

public class ArtistDAO {
    public void create(String myName) throws SQLException {
        Connection con = DataBase.getConnection();
        /*try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, myName);
            int result = pstmt.executeUpdate();
            if(result == 0)
                throw new SQLException("Creating artist failed, no rows affected.");
            else{
                DataBase.getConnection().commit();
                System.out.println("Artist " + myName + " added to the database");
            }
        }*/
        /*try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, myName);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        }*/
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, myName);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}

package homework;

import homework.Albums;

import java.sql.*;

public class AlbumsDAO extends DAO<Albums>
{

    static Connection conn;
    static
    {
        try
        {
            conn = Database.getConnection();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //
    @Override
    public void create(Albums album) throws SQLException
    {

        PreparedStatement ps = null;
        try
        {
            ps = conn.prepareStatement("INSERT INTO albums ( title, release_year, artistid) VALUES ( ?, ?, ?);");

            ps.setString(1, album.getName());
            ps.setInt(2, album.getReleaseYear());
            ps.setInt(3, album.getArtistId());
            ps.executeUpdate();
            //conn.commit();
        } catch (SQLException e)
        {
            System.out.println("Error creating album: " + e);
        }
    }

    @Override
    public Albums findByName(String name) throws SQLException
    {

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, release_year, artistid from albums where title=" + "'" + name + "'"))
        {
            return rs.next() ? new Albums(rs.getInt(1), name, rs.getInt(2), rs.getInt(3)) : null;
        }

    }

    @Override
    public Albums findById(int id) throws SQLException
    {

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title, release_year, artistid from albums where id=" + "'" + id + "'"))
        {
            return rs.next() ? new Albums(id, rs.getString(1), rs.getInt(2), rs.getInt(3)) : null;
        }

    }

}

package homework;

import java.sql.*;

public class ArtistDAO extends  DAO<Artists>
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

    @Override
   public void create(Artists artist) throws SQLException
    {

        PreparedStatement ps = null;
        try
        {
            ps = conn.prepareStatement("INSERT INTO artist ( name) VALUES ( ?);");
            ps.setString(1, artist.getName());
            ps.executeUpdate();
            //conn.commit();
        } catch (SQLException e)
        {
            System.out.println("Error creating artist: " + e);
        }

    }

    @Override
    public Artists findByName(String name) throws SQLException
    {
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM artist WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return new Artists(rs.getInt(1), rs.getString(2));
            }
            else
            {
                return null;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error finding artist: " + e);
        }

        return null;
    }

    @Override
    public Artists findById(int id) throws SQLException
    {

         try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(
                      "select name from artist where id=" + "'" + id  +"'")) {
              return rs.next() ? new Artists(id, rs.getString(1)) : null;
         }
    }
}

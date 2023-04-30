package homework;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.sql.*;

public class GenresDAO extends DAO<Genres>
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
    public void create(Genres info) throws SQLException
    {

        PreparedStatement ps = null;
        try
        {
            ps = conn.prepareStatement("INSERT INTO genre (name) VALUES (?);");

            ps.setString(1, info.getName());
            ps.executeUpdate();
            //conn.commit();
        } catch (SQLException e)
        {
            System.out.println("Error creating genre: " + e);
        }

    }

    @Override
    public Genres findByName(String name) throws SQLException
    {


        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select id from genres where name=" + "'" + name + "'"))
        {
            return rs.next() ? new Genres(rs.getInt(1), name) : null;
        } catch (SQLException e)
        {
            System.out.println("Error finding genre: " + e);
        }

        return null;
    }

    @Override
    public Genres findById(int id) throws SQLException
    {

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id=" + "'" + id + "'"))
        {
            return rs.next() ? new Genres(id, rs.getString(1)) : null;
        } catch (SQLException e)
        {
            System.out.println("Error finding genre: " + e);
        }
        return null;
    }
}

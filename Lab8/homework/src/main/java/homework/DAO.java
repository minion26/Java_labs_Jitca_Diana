package homework;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * This class defines the abstract behavior of a DAO (Data Access Object).
 */
public abstract class DAO<T>
{
    //Optional<T>  get(int id) throws SQLException;
    public abstract void create(T info) throws SQLException;


    public abstract T findByName(String name) throws SQLException;

    public abstract T findById(int id) throws SQLException;

}

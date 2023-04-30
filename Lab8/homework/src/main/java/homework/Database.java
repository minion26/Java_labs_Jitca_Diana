package homework;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database
{

    private static HikariConfig cfg  = new HikariConfig();
    private static HikariDataSource datasource ;



    private static final String URL =
            "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
   // private static Connection connection = null;


    static
    {
        cfg.setJdbcUrl( URL );
        cfg.setUsername( USER );
        cfg.setPassword( PASSWORD );
        cfg.addDataSourceProperty( "cachePrepStmts" , "true" );
        cfg.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        cfg.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        cfg.setConnectionTimeout(1000000);
        cfg.setIdleTimeout(600000);
        cfg.setMaxLifetime(1800000);
          // cfg.setConnectionTimeout(300000);
        datasource = new HikariDataSource( cfg );

    }

    Database() {}

    public static Connection getConnection() throws SQLException
    {

        return datasource.getConnection();
    }

//    public static void createConnection() throws SQLException
//    {
//
//        try
//        {
//        connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Connected to database");
//        }
//        catch (SQLException e)
//        {
//            System.out.println("Error creating connection to database: " + e);
//            System.exit(-1);
//        }
//    }

//    public static  void stopConnection() throws SQLException
//    {
//        connection.close();
//    }



}

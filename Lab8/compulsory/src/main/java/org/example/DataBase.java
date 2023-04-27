package org.example;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;


public class DataBase {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection = null;
    private DataBase() throws IOException {}

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            createConnection();
        }
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false);
        System.out.println("Connection reassembled");

        return connection;
    }
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            ScriptRunner sr = new ScriptRunner(connection);
            //Creating a reader object
            Reader reader = new BufferedReader(new FileReader("C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab8\\script.sql"));
            //Running the script
            sr.runScript(reader);
            System.out.println("Connection SQL script executed");
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /*private static void executeSqlFile() {
        try {
            Runtime rt = Runtime.getRuntime();
            String executeSqlCommand = "psql -U postgres -h albums -f C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab8\\script.sql";
            Process pr = rt.exec(executeSqlCommand);
            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }*/

}

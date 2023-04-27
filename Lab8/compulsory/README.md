JDBC
Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.

The main specifications of the application are :unicorn: : :unicorn:

  1. Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
  
  2. Write an SQL script that will create the following tables:
          albums: id, release year, title, artist, genre(s)
          artists: id, name (for example: Beatles)
          genres: id, name (for example: Rock)
          an associative (junction) table in order to store each album genres
          
  3. Update pom.xml, in order to add the database driver to the project libraries.
  
  4. Create a singleton class in order to manage a connection to the database.
  
  5. Create DAO classes that offer methods for managing artists, genres and albums (at least one).
  
  6. Implement a simple test using your classes.

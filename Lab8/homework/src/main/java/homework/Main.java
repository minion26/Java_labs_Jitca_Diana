package homework;

import org.apache.ibatis.jdbc.ScriptRunner;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException, FileNotFoundException
    {
        Connection connection = Database.getConnection();

        //populate the database using a script
        ScriptRunner sr = new ScriptRunner(connection);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab8\\script.sql"));
        //Run the script on the database

        // sr.runScript(reader);

        Populate populate = new Populate("C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab8\\src\\main\\resources\\albumlist.csv");

        AlbumsDAO albumsDAO = new AlbumsDAO();
        ArtistDAO artistDAO = new ArtistDAO();
        GenresDAO genresDAO = new GenresDAO();

        System.out.println("Populating database...");

        while (!populate.isEmpty())
        {
            String[] line = populate.popLine();
            String releaseYear = line[0];
            String albumName = line[1];
            String artistName = line[2];
            String genre = line[3];
            //insert the artist into the database

            //insert the data into the database


            artistDAO.create(new Artists(artistName));
            albumsDAO.create(new Albums(albumName, artistDAO.findByName(artistName).getId(), Integer.parseInt(releaseYear)));
            genresDAO.create(new Genres(genre));


        }


    }

}

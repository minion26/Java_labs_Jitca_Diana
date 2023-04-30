package homework;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * This class defineds the behavior of the Populate class that populates the music database from a data file
 */
public class Populate
{
    List<String[]> data;
   String dataFilePath;

    public Populate(String path)
    {
        this.dataFilePath = path;
        this.data = readAll(); //read all the data from the file
    }

    Boolean isEmpty()
    {
        return data.isEmpty();
    }
    public String[] popLine()
    {
        //get a line from  the file and then remove it
        String[] line = data.get(0);
        data.remove(0);
        return line;



    }

    private List<String[]> readAll()
    {

        try (CSVReader reader = new CSVReader(new FileReader(dataFilePath)))
        {
            return reader.readAll();
        } catch (IOException | CsvException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}

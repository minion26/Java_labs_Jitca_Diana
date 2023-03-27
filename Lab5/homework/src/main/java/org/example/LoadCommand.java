package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
/*This class loads the catalog from an external file.
* @author Jitca Diana*/

public class LoadCommand {
    public Catalog load(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Catalog catalog = new Catalog();
        try {
            HashSet<Document> documents = mapper.readValue(new File(path), HashSet.class);
            catalog.setDocuments(documents);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return catalog;
    }

}

package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
/*
* This is a class that implements an catalog with documents.
* @author Jitca Diana*/
public class Catalog implements Serializable, Commands {
    private Set<Document> documents = new HashSet<>();

    public Catalog() {
    }

    public void add(Document doc) {
        try {

            for(Document d: documents){
                if(d.getID() == doc.getID()){
                    throw new Exception("Id is used");
                }
            }
            documents.add(doc);

        } catch (Exception e) {
            System.out.println("Error adding document, document already exists");
        }
    }

    public Document findById(String id) {
        for (Document d : documents) {
            if (d.getID().equals(id)) {
                return d;
            }
        }
        return null;
    }

    //save the catalog in json
    @Override
    public void save() throws IOException {
        ObjectMapper mapper = new ObjectMapper();


            try {
                mapper.writeValue(new File("C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab5\\catalog.json"), documents);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }


    }

    //load the catalog from json
/*    @Override
    public Catalog load(String path) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Catalog catalog = new Catalog();
        try {
            HashSet<Document> documents = mapper.readValue(new File(path), HashSet.class);
            catalog.setDocuments(documents);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return catalog;
    }*/

    @Override
    public String toString() {
        return "Catalog{" +
                "documents=" + documents +
                '}';
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}




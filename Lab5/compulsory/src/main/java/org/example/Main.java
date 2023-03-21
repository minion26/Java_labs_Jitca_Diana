package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //create an instance of Catalog
        Catalog c = new Catalog();

        //create two documents
        Document d = new Document("java1", "java1.pdf");
        Document d2 = new Document("java2", "java2.pdf");
        Document d3 = new Document("java2", "java2.pdf");

        //add tags to documents
        d.addTag("type", "Slides");
        d2.addTag("author", "JD");

        //add them to the catalog
        c.add(d);
        c.add(d2);
        c.add(d3);

        //save the catalog in json
        c.save();

        //load the catalog from json
        System.out.println(c.load("C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab5\\catalog.json"));

        //the toString method
        //System.out.println(c.toString());
    }
}
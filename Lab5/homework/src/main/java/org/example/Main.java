package org.example;
/*
* This Main class shows the functionalities.
* @author Jitca Diana*/

import javax.swing.text.View;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        /*create an instance of Catalog*/
        Catalog c = new Catalog();

        /*create two documents*/
        Document d = new Document("java1", "java1.pdf", "C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab5\\java1.pdf");
        Document d2 = new Document("java2", "java2.pdf", "C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab5\\java2.pdf");
        Document d3 = new Document("guitar", "guitar.png", "C:\\Users\\jitca\\Desktop\\guitar chords.jpg");
        Document durl = new Document("url", "url", "https://www.google.com/");

        /*add tags to documents*/
        d.addTag("type", "Slides");
        d2.addTag("author", "JD");

        /*add them to the catalog*/
        c.add(d);
        c.add(d2);
        c.add(d3);
        c.add(durl);

        /*save the catalog in json*/
        c.save();


        /*load the catalog from json using the load method from LoadCommand class*/
        LoadCommand loadCommand = new LoadCommand();
        System.out.println("Load command: " + loadCommand.load("C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab5\\catalog.json"));

        /*list the documents from the catalog using the generic implementation*/
        ListCommand listCommand = new ListCommand(c);
        listCommand.execute();

        /*view a document from the catalog using the generic implementation*/
        ViewCommand viewCommand = new ViewCommand(d3);
        viewCommand.execute();

        /*report command*/
        ReportCommand reportCommand = new ReportCommand();
        reportCommand.report(c);
        Document html = new Document("html", "html", "http://localhost:63342/Lab5/hello.html?_ijt=tc0hdufideknvtu639764g6145&_ij_reload=RELOAD_ON_SAVE");
        c.add(html);
        c.save();
        ViewCommand viewCommand2 = new ViewCommand(html);
        viewCommand2.execute();
    }
}
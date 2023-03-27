package org.example;

import java.awt.*;
import java.io.File;
/*
* This class implements an interface for commands and
* opens a document using the native operating system application (see the Desktop class);
* @author Jitca Diana*/

public class ViewCommand implements GenericCommand{
    /* opens a document using the native operating system application (see the Desktop class);*/
    private Document document;
    public ViewCommand(Document document){
        this.document = document;
    }
    @Override
    public void execute() {
        Desktop desktop = Desktop.getDesktop();
        String path = document.getPath();
        try {
            if(path.contains("C:\\")){
                File filePath = new File(path);
                desktop.open(filePath);
            }
            else{
                desktop.browse(new java.net.URI(path));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

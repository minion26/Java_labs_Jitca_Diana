package org.example;
/*
* This class implements an interface for commands and prints the list of documents on the screen
* @author Jitca Diana*/
public class ListCommand implements GenericCommand{
    //prints the list of documents on the screen;
    private Catalog catalog;

    public ListCommand(Catalog catalog){
        this.catalog = catalog;
    }


    @Override
    public void execute() {
        if(catalog.getDocuments().isEmpty()){
            try {
                throw new ListException();
            } catch (ListException e) {
                /*using a custom exception*/
                System.out.println(e.getMessage());
            }
        }

        //else, print the list of documents
        for (Document d : catalog.getDocuments()) {
            System.out.println(d.toString());
        }
    }
}

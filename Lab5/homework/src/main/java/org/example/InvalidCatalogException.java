package org.example;
/*This class is a custom exception
 * @author Jitca Diana*/
public class InvalidCatalogException extends Exception{
    public InvalidCatalogException(Exception ex){
        super("Invalid catalog file.", ex);
    }
}

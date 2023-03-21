package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public interface Commands{

    public void save() throws IOException;


    public  Catalog load(String path)  throws IOException;


}

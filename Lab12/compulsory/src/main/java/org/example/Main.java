package org.example;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

public class Main {

    public static void displayDirectoryContents(File dir) {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory: " + file.getCanonicalPath());
                    displayDirectoryContents(file);
                } else {
                    System.out.println("     file: " + file.getCanonicalPath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        DynamicClassAnalyzer dynamicClassAnalyzer = new DynamicClassAnalyzer();

        String className = "org.example.Testing";
        String pathName = "C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab4_compulory\\target\\classes";


        dynamicClassAnalyzer.extractInformation(dynamicClassAnalyzer.pathAndClassLoader(pathName, className));


        //test the static methods in the class Testing

        dynamicClassAnalyzer.testStaticMethods(dynamicClassAnalyzer.pathAndClassLoader(pathName,"org.example.Testing"));

    }

}
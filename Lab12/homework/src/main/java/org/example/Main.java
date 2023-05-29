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


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DynamicClassAnalyzer dynamicClassAnalyzer = new DynamicClassAnalyzer();

        String className = "org.example.Testing";
        String pathName = "C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab4_compulory\\target\\classes";

        Class classTest = dynamicClassAnalyzer.pathAndClassLoader(pathName, className );


        //dynamicClassAnalyzer.extractInformation(dynamicClassAnalyzer.pathAndClassLoader(pathName, className));


        //test the static methods in the class Testing
        //dynamicClassAnalyzer.testStaticMethods(dynamicClassAnalyzer.pathAndClassLoader(pathName,"org.example.Testing"));

        //test the methods in the class Testing
        //Main.displayDirectoryContents(new File(pathName));


        for(Class myClass : DynamicClassAnalyzer.getClassesFromJarFile(new File("C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab4_compulory\\target\\Lab4_compulory-1.0-SNAPSHOT.jar"))){
            dynamicClassAnalyzer.createMyPrototype(myClass);
            if(myClass.getConstructors().length != 0) {
                Annotation[] annotations = myClass.getConstructors()[0].getAnnotations();

                if (annotations.length > 0 && annotations[0].annotationType().getName().equals("org.junit.Test")) {
                    System.out.println("AM INTRAT");
                }
                try {
                    System.out.println("TEST THE METHODS");
                    dynamicClassAnalyzer.testMethods(myClass);

                    System.out.println("TEST THE STATIC METHODS");
                    dynamicClassAnalyzer.testStaticMethods(myClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


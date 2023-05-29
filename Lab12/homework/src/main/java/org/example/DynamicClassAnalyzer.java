package org.example;

import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class    DynamicClassAnalyzer {

    /**
     * Ia ca parametru un path cu fisiere .class si afiseaza package-ul*/
    public Class ourClassLoader(String className) {
        Class ourClass = null;
        try (URLClassLoader urlLoader = new URLClassLoader(
                new URL[0],
                this.getClass().getClassLoader())) {
            try {
                ourClass = urlLoader.loadClass(className);
                System.out.println("Our class package is : " + ourClass.getPackage());
            } catch (ClassNotFoundException exception) {
                System.out.println(exception);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourClass;
    }


    /**
     * Load the specified class from the specified file in the memory
     * */
    public Class pathAndClassLoader(String pathName, String className) {
        MyClassLoader classLoader = new MyClassLoader();
        File path = new File(pathName);

        if (path.exists()) {
            URL url = null;
            try {
                url = path.toURI().toURL();
                System.out.println("url is : " + url);

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            classLoader.addURL(url);
        } else {
            System.out.println("path doesn't exist");
        }
        Class clazz = null;
        try {
            clazz = classLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clazz;
    }


    public void extractInformation(Class clazz) {
        System.out.println("Information about " + clazz.getName());
        System.out.println("Package: " + clazz.getPackage());
        System.out.println("Superclass: " + clazz.getSuperclass().getName());
        System.out.println(Arrays.toString(clazz.getInterfaces()));
        System.out.println("Constructors: " + Arrays.toString(clazz.getConstructors()));
        for (Method method : clazz.getMethods()) {
            System.out.println(clazz.getName() + " has method: " + method);
        }
        for (Field field : clazz.getFields()) {
            System.out.println(clazz.getName() + " has field : " + field);
        }
        for (Class c : clazz.getClasses()) {
            System.out.println(clazz.getName() + " has inner class : " + c);
        }
        for (Class c : clazz.getDeclaredClasses()) {
            System.out.println(clazz.getName() + " has declared class : " + c);
        }

    }

    public void testStaticMethods(Class className) {
        System.out.println("Running tests for : " + className.getName());
        int passed = 0, failed = 0;
        for (Method m : className.getMethods()) {

            if ( Modifier.isStatic(m.getModifiers()) && m.isAnnotationPresent(org.junit.Test.class)) {
               // System.out.println("Method name is : " + m.getName());
                try {
                    System.out.println("output from method : " + m.invoke(null));
                    passed++;
                    System.out.println("Method " + m + " passed!");
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }


    public void testMethods(Class className) throws ClassNotFoundException {
        Random random = new Random();
        System.out.println("Running tests for : " + className.getName());

        int passed = 0, failed = 0;

        for (Method m : className.getMethods()) {
            Annotation[] declaredAnnotations = m.getDeclaredAnnotations();
            System.out.println("Method name is : " + m.getName());
            if(declaredAnnotations.length > 0) {

                if (declaredAnnotations[0].annotationType().getName().equals("org.junit.Test")) {
                    try {
                        switch (m.getParameters()[0].getName()) {
                            case "char":
                                m.invoke(className.newInstance(), 'a' + random.nextInt(26));
                                break;
                            case "String":
                                byte[] letters = new byte[7];
                                random.nextBytes(letters);
                                String randomString = new String(letters, StandardCharsets.UTF_8);
                                m.invoke(className.newInstance(), randomString);
                                break;
                            case "int":
                                m.invoke(className.newInstance(), random.nextInt());
                                break;
                        }
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n",
                                m, ex.getCause());
                        failed++;
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }


    /**
     * scan the JAR file from a Java program and get the class names */
    private static Set<String> getClassNamesFromJarFile(File givenFile) throws IOException {
        Set<String> classNames = new HashSet<>();
        try (JarFile jarFile = new JarFile(givenFile)) {
            Enumeration<JarEntry> e = jarFile.entries();
            while (e.hasMoreElements()) {
                JarEntry jarEntry = e.nextElement();
                if (jarEntry.getName().endsWith(".class")) {
                    String className = jarEntry.getName()
                            .replace("/", ".")
                            .replace(".class", "");
                    classNames.add(className);
                }
            }
            return classNames;
        }
    }

    /**
     * load some classes from a JAR file at runtime dynamically.*/
    public static Set<Class> getClassesFromJarFile(File jarFile) throws IOException, ClassNotFoundException {
        Set<String> classNames = null;
        try{
            classNames = getClassNamesFromJarFile(jarFile);
        }
        catch (IOException e){
            System.out.println("IOException");
        }

        Set<Class> classes = new HashSet<>(classNames.size());
        try (URLClassLoader cl = URLClassLoader.newInstance(
                new URL[] { new URL("jar:file:" + jarFile + "!/") })) {
            for (String name : classNames) {
                Class clazz = cl.loadClass(name); // Load the class by its name
                classes.add(clazz);
            }
        }
        return classes;
    }

    public void createMyPrototype(Class className) {
        int modifiers = className.getModifiers();
        StringBuilder myClassSignature = new StringBuilder();
        if (Modifier.isPublic(modifiers)) {
            myClassSignature.append("public ");
        }
        if (Modifier.isAbstract(modifiers)) {
            myClassSignature.append("abstract ");
        } else if (Modifier.isInterface(modifiers)) {
            myClassSignature.append("interface ");
        }
        if (Modifier.isFinal(modifiers)) {
            myClassSignature.append("final ");
        }
        myClassSignature.append(className.getName()).append(" {\n");

        for (Constructor constructor : className.getConstructors()) {
            myClassSignature.append("   ").append(constructor).append("\n");
        }
        for (Field field : className.getDeclaredFields()) {
            myClassSignature.append("   ").append(field).append("\n");
        }
        for (Method method : className.getMethods()) {
            myClassSignature.append("   ").append(method).append("\n");
        }
        myClassSignature.append("}");
        System.out.println(myClassSignature);
    }
}

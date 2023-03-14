package org.example;

import java.util.*;
import java.util.stream.IntStream;
/*
* This is the main class
* it shows the functionality*/
public class Main {
    public static void main(String[] args) {
        //creating the objects with streams
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);

        //adding the projects for every student object
        students[0].addProject(projects[0]);
        students[0].addProject(projects[1]);
        students[0].addProject(projects[2]);

        students[1].addProject(projects[0]);
        students[1].addProject(projects[1]);

        students[2].addProject(projects[0]);


        //creating the list of students
        List<Student> std = new LinkedList<>();
        std.add(students[0]);
        std.add(students[2]);
        std.add(students[1]);


        //creating the treeset for projects
        Set<Project> prj = new TreeSet<>(Project::compareTo);
        prj.add(projects[0]);
        prj.add(projects[2]);
        prj.add(projects[1]);


        //showing the list sorted and unsorted
        System.out.println("Inainte de sortare: " + std);
        std.sort(Comparator.comparing(Student::getName));
        System.out.println("Dupa sortare: " + std);


        //showing the treeset
        System.out.println("Sortat: " + prj);



    }
}
package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;
/*
* This is the main class
* it shows the functionality*/
public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        /*creating the objects with streams*/
        var students = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Student(faker.name().fullName() ))
                .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);


        /*instantiated the problem*/
        StudentAllocation studentAllocation = new StudentAllocation();

        /*add the students to the map*/
        for (Student student : students) {
            studentAllocation.addStudent(student);
        }

        /*add the projects to a list for projects available*/
        for (Project project : projects) {
            studentAllocation.addProjectAvaible(project);
        }

        /*allocating a random number of projects randomly*/
        for(Student s:students){
            //random number of projects for each student
            int nr = (int)(Math.random()*5);
            List<Project> proj = new ArrayList<>();
            for(int i=0; i<nr; i++){
                //random project for each student
                int nr2 = (int)(Math.random()*5);
                //add the project to arraylist
                if(!proj.contains(projects[nr2])){
                    proj.add(projects[nr2]);
                }else{
                    i--;
                }
            }
            //add the projects to the map
            studentAllocation.addProjects(s, (ArrayList<Project>) proj);
        }

        //print the map
        studentAllocation.print();
        System.out.println();

        //studentAllocation.displayAverage();

        System.out.println("Greedy allocation: ");
        studentAllocation.greedyAllocation();
    }
}
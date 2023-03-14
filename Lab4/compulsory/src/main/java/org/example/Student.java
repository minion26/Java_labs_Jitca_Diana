package org.example;

import java.util.ArrayList;
import java.util.List;
/*
* This class is for the students
* It implements the comparable interface
* It has a list for every project to add the ones he wants
* @author Jitca Diana*/

public class Student implements Comparable<Student>{

    private String name;

    private List<Project> list = new ArrayList<>();

    //method for adding projects in the list
    public void addProject(Project proj){
        list.add(proj);
    }

    //constructor
    public Student(String myName){
        this.name = myName;
    }

    //setters and getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

}

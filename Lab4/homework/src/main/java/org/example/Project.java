package org.example;

import java.util.ArrayList;
import java.util.List;
/*
* This class is for the projects
* it implements the Comparable interface
* @author Jitca Diana*/

public class Project implements Comparable<Project>{

    private String projectName;

    //constructor
    public Project(String name){
        this.projectName = name;
    }


    //setters and getters
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Project o) {
        return (this.projectName).compareTo(o.projectName);
    }
}

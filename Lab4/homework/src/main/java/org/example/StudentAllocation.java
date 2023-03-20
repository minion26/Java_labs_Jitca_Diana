package org.example;
/*This is a class that describes the problem of student-projects allocation.
* @author Jitca Diana*/

import java.util.*;

public class StudentAllocation {

    /* map for students and their preferences*/
    private Map<Student, ArrayList<Project>> myMap = new HashMap<>();
    /* list for available projects*/
    private List<Project> projectsAvaible = new ArrayList<>();


    /* adding an available project to the list
    * @param: project*/
    void addProjectAvaible(Project project) {
        projectsAvaible.add(project);
    }

    /* adding the array of projects for a student to the map
    * @params: student, array of projects*/
    public void addProjects(Student student, ArrayList<Project> projects) {
        myMap.put(student, projects);

    }

    /* adding a student to the map*/
    public void addStudent(Student student) {
        myMap.put(student, new ArrayList<>());
    }

    /* get the projects of a student*/
    public ArrayList<Project> getProjects(Student student) {
        return myMap.get(student);
    }

    /*remove the project*/
    public void removeProject(Student student, Project project) {
        //find the project in the list of projects for the student
        //remove the project from the list
        //update the map
        for (Project p : myMap.get(student)) {
            if (p.equals(project)) {
                myMap.get(student).remove(p);
                break;
            }
        }

    }

    /* display all the students that have a number of preferences lower than the average number of preferences*/
    public void displayAverage() {
        //calculate the average number of projects for all students
        double average = myMap.values().stream().mapToInt(ArrayList::size).average().getAsDouble();

        System.out.println("Average number of projects: " + average);
        //display the students that have fewer projects than the average
        myMap.entrySet().stream().filter(s -> s.getValue().size() < average).forEach(e -> System.out.println(e.getKey().getName()));

    }

    public void print() {
        myMap.forEach((k, v) -> System.out.println(k.getName() + " " + v));
    }

    /*  Greedy algorithm */
    public void greedyAllocation() {
        /*map that stores the allocation of projects for each student*/
        Map<Student, Project> allocation = new HashMap<>();

        /*list of students with projects allocates*/
        List<Student> studentsAllocated = new ArrayList<>();

        /*list of students..maybe we want it ordered*/
        List<Student> orderedStudents = new ArrayList<>();
        orderedStudents.addAll(myMap.keySet());
        //orderedStudents.sort(Comparator.comparing(e -> myMap.get(e).size()).reversed());


        /*for each student in the map*/
        for (Student s : orderedStudents) {

            if (myMap.get(s).size() > 0) {
                /*find the first project available for the student*/
                for (Project p : myMap.get(s)) {

                    /*if the project is available*/
                    if (projectsAvaible.contains(p)) {

                        /*add the student and the project to the map*/
                        allocation.put(s, p);

                        /*remove the project from the list of available projects*/
                        projectsAvaible.remove(p);

                        /*add the student to the list of students with projects allocated*/
                        studentsAllocated.add(s);
                        break;
                    }
                }

                if(!allocation.containsKey(s)){
                    Project project = projectsAvaible.get(0);
                    allocation.put(s, project);
                    projectsAvaible.remove(project);
                    /*add the student to the list of students with projects allocated*/
                    studentsAllocated.add(s);
                }

            }
            if(myMap.get(s).size() == 0){
                /*if the student has no preferences*/
                Project project = projectsAvaible.get(0);
                allocation.put(s, project);
                projectsAvaible.remove(project);
                /*add the student to the list of students with projects allocated*/
                studentsAllocated.add(s);
            }
        }


        /*displaying the allocation of projects for each student*/
        allocation.forEach((k, v) -> System.out.println(k.getName() + " " + v));
        System.out.println();

        /*display the students that have not been allocated a project*/
        System.out.println("Students that have not been allocated a project: ");
        myMap.keySet().stream().filter(s -> !studentsAllocated.contains(s)).forEach(s -> System.out.println(s.getName()));

        /*display the projects that have not been allocated to any students*/
        System.out.println("Projects that have not been allocated: ");
        projectsAvaible.forEach(System.out::println);

    }
}

/*
 * This is a class for the people who work at companies
 * It  implements the interface java.util.Comparable and the interface Node
 * @author Jitca Diana*/

public class Person extends NodeOfNetwork implements Node{


    /*public int compareTo(Person o) {
        if (this.personName.compareTo(o.personName) == 0){
            return 0;
        }
        else{
            if(this.personName.compareTo(o.personName) < 0){
                return -1;
            }else{
                return 1;
            }
        }
    }*/

    private String personName;
    private String birthday;
    Person(String name, String bday){
        this.personName = name;
        this.birthday = bday;
    }

    public String getName(){
        return this.personName + "[PERSON]";
    }

    public void setName(String n){
        this.personName = n;
    }

    @Override
    public boolean equals(Object o) {
        return compareTo((Person)o)==0;
    }


    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }



}


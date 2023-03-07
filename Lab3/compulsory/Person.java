import java.util.Objects;
/*
* This is a class for the people who work at companies
* It  implements the interface java.util.Comparable and the interface Node
 * @author Jitca Diana*/

public class Person implements Comparable<Person>, Node{

    @Override
    public int compareTo(Person o) {
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
    }

    private String personName;
    Person(String name){
        this.personName = name;
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
}

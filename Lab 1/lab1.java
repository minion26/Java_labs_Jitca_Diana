

public class lab1 {
    public static void main(String[] args){

        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1000000);


        n = n * 3;
        n = n + Integer.parseInt("10101", 2);
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;
        System.out.println(n);


        int sum ; 
        if (n % 9 == 0){
            sum = 9;
        }else{
            sum = n % 9;
        }


        // int [] array = new int [10];
        // array[1]  = 10;
       // System.out.print(array[1]);

        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);
    }
}

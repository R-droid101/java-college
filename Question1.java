import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter n:");
        n = sc.nextInt(); // Reading n from the user
        sc.nextLine();
        int regCount = 0, cgpaCount = 0, nameCount = 0, great = Integer.MIN_VALUE, least = Integer.MAX_VALUE; // Counter variables for each type of input and variables to store greatest and least
        float sum = 0; // To calculate average of CGPA
        String names = ""; // To store names with comma inbetween them
        System.out.println("Enter " + n + " students' details:");
        for(int i = 0; i < n; i++) {
            if(sc.hasNextInt()) { // Checking if the input is registration number
                int rno = sc.nextInt();
                if(rno > great) 
                    great = rno;
                if(rno < least)
                    least = rno;
                regCount++;
            }
            else if(sc.hasNextFloat()) { // checking if input is CGPA
                float cgpa = sc.nextFloat();
                sum += cgpa;
                cgpaCount++;
            }
            else { // Checking if input is name
                String name = sc.next();
                names += name + ", ";
                nameCount++;
            }
        }
        // printing out the details
        System.out.println("\n\nNumber of registration numbers: " + regCount);
        System.out.println("Number of CGPA: " + cgpaCount);
        System.out.println("Number of names: " + nameCount);
        System.out.println("Greatest registration number: " + great);
        System.out.println("Least registration number: " + least);
        if(cgpaCount != 0) 
            System.out.println("Average CGPA: " + (sum / cgpaCount));
        System.out.println("Names: " + names.substring(0, names.length() - 2));

        sc.close();
    }
}

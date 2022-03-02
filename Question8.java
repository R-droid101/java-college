import java.util.*;

class Faculty { // faculty class
    double avg, max;
    Student studs[];

    Faculty(int n, Scanner sc) { // reading the student details
        studs = new Student[n];
        for (int i = 0; i < n; i++) {
            studs[i] = new Student(sc);
        }
    }

    void findClassAverage() { // finding the class average
        double c = 0;
        for (Student stud : studs)
            c += stud.getIndividualTotal();
        avg = c / studs.length;
        System.out.println("Class Average: " + avg);
    }

    void findMaxScore() { // to find the max score
        max = 0;
        double indTotal; // to store the individual total of a student
        for (Student stud : studs) {
            indTotal = stud.getIndividualTotal();
            if (indTotal > max)
                max = indTotal; // finding what the max score is
        }
        printInternalMax();
    }

    private void printInternalMax() { // ask ma'am and then finish
        System.out.println("Highest Internal Marks: " + max);
    }

    class Student { // student class
        int tot; // to store total score of the students
        int marks[] = new int[5]; // marks of 5 subjects

        Student(Scanner sc) { // reading the marks of the student and setting default values
            tot = 0;
            for (int i = 0; i < 5; i++)
                marks[i] = sc.nextInt();
        }

        int getIndividualTotal() { // getting the total score of the student
            tot = 0;
            for (int mark : marks)
                tot += mark;
            return tot;
        }
    }
}

public class Question8 { // main class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt(); // number of students
        sc.nextLine();
        Faculty fc = new Faculty(n, sc);
        // doing the necessary operations
        fc.findClassAverage();
        fc.findMaxScore();
        sc.close();
    }
}

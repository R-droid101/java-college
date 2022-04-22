import java.util.*;

class Line {
    int x1, y1, x2, y2;

    Line(int a1, int b1, int a2, int b2) throws NumberFormatException {
        if (a1 == a2 && b1 == b2)
            throw new NumberFormatException();
        x1 = a1;
        y1 = b1;
        x2 = a2;
        y2 = b2;
    }
}

class TriangleNotPossibleException extends Exception {
    public String toString() {
        return "Exception: TriangleNotPossible";
    }
}

class Triangle {
    Line l1, l2;

    Triangle(int a1, int b1, int a2, int b2, int a3, int b3, int a4, int b4) throws TriangleNotPossibleException {
        l1 = new Line(a1, b1, a2, b2);
        l2 = new Line(a3, b3, a4, b4);
        if (!((a1 == a3 && b1 == b3) || (a2 == a3 && b2 == b3) ||
                (a1 == a4 && b1 == b4) || (a2 == a4 && b2 == b4)))
            throw new TriangleNotPossibleException();
    }
}

public class Question11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int a1, b1, a2, b2, a3, b3, a4, b4;
        while (true) {
            count++;
            System.out.print("Enter coordinates of first point: ");
            a1 = sc.nextInt();
            b1 = sc.nextInt();
            System.out.print("Enter coordinates of second point: ");
            a2 = sc.nextInt();
            b2 = sc.nextInt();
            System.out.print("Enter coordinates of third point: ");
            a3 = sc.nextInt();
            b3 = sc.nextInt();
            System.out.print("Enter coordinates of fourth point: ");
            a4 = sc.nextInt();
            b4 = sc.nextInt();
            try {
                new Triangle(a1, b1, a2, b2, a3, b3, a4, b4);
                break;
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("Please try again");
            }
        }
        System.out.println("Triangle successfully formed");
        System.out.println(count + " attempts taken");
        sc.close();
    }
}

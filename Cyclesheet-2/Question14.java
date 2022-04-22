import java.util.*;

public class Question14 {

    static Scanner sc = new Scanner(System.in);

    static void inputFunc() throws InputMismatchException {
        sc.nextInt();
    }

    public static void main(String[] args) {
        int integers = 0, floats = 0;
        System.out.println("Enter your numbers: ");
        for (int i = 0; i < 10; i++) {
            try {
                inputFunc();
                integers++;
            } catch (InputMismatchException e) {
                sc.nextFloat();
                floats++;
                continue;
            }
        }
        sc.close();
        System.out.println("Integers: " + integers);
        System.out.println("Floats: " + floats);
    }
}

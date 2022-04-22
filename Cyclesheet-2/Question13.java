import java.util.*;

public class Question13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> fac = new LinkedList<>();
        Queue<Integer> men = new LinkedList<>();
        Queue<Integer> women = new LinkedList<>();
        int prices[] = { 50, 75, 100, 150 };
        int choice, n = 0, order[] = new int[4], sum, w = 0, m = 0, f = 0;

        while (true) {
            // Checking for entry/exit
            System.out.println("----MENU----");
            System.out.println("Press 0 to add another entry");
            System.out.println("Press 1 to exit");
            System.out.print("Enter: ");
            choice = sc.nextInt();
            if (choice == 1)
                break;
            else if (choice > 1) {
                System.out.println("Incorrect input");
                continue;
            }
            n++;
            // Inputting order
            System.out.print("Enter number of items for the 4 dishes (n1 ... n4) : ");
            sum = 0;
            for (int i = 0; i < prices.length; i++) {
                order[i] = sc.nextInt();
                sum += order[i] * prices[i];
            }
            // Adding bill total to each appropriate queue
            if (n % 5 == 0) {
                w++;
                women.add(sum);
            } else if (n % 5 == 4) {
                m++;
                men.add(sum);
            } else {
                f++;
                fac.add(sum);
            }
        }
        sc.close();

        // Displaying required output
        System.out.println("\nTotal number of faculty: " + f);
        System.out.println("Faculty's Bills: ");
        System.out.println(fac);

        System.out.println("\nTotal number of students - men, women (sum): " + m + ", " + w + " (" + (m + w) + ")");
        System.out.println("Men's Bills: ");
        System.out.println(men);
        System.out.println("Women's Bills: ");
        System.out.println(women);
    }
}

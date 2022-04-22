import java.util.*;

public class Question3i {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of terms:");
        int n = sc.nextInt(), sum = 0;
        for(int i = 1; i <= n; i++) {
            int num = 0;
            for(int j = 0; j < i; j++) {
                num += (int) Math.pow(10, j) * i;
            }
            if(i % 2 == 0)
                sum -= num;
            else
                sum += num;
        }
        System.out.println("Sum = " + sum);
        sc.close();
    }
}

import java.util.*;

public class Question4 {
    static void operation(int num, int arr[]) {
        int orOperation, xorOperation, len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                orOperation = arr[i] | arr[j];
                xorOperation = arr[i] ^ arr[j];
                System.out.println("(" + arr[i] + "," + arr[j] + ") OR=" + orOperation + " XOR=" + xorOperation);
                if (orOperation == xorOperation) {
                    System.out.println("Row " + num + " is abruptly terminated");
                    return;
                }
            }
        }
        System.out.println("Row " + num + " is processed entirely");
    }

    static int[] contigElem(int num, int arr[]) {
        int sum = 0, len = arr.length - num;
        int arr1[] = new int[len];
        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = 0; j <= num; j++)
                sum += arr[i + j];
            arr1[i] = sum;
        }
        return arr1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int ar[][] = new int[n - 1][];
        for (int i = 0; i < n - 1; i++)
            ar[i] = new int[n - i];

        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++)
            ar[0][i] = sc.nextInt();
        System.out.println("\nOutput:");
        for (int i = 1; i < n - 1; i++)
            ar[i] = contigElem(i, ar[0]);
        for (int i = 1; i < n - 1; i++)
            operation(i - 1, ar[i]);
        sc.close();
    }
}

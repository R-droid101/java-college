import java.util.*;

class NotPrimeException extends Exception {
    private int n;

    NotPrimeException(int x) {
        n = x;
    }

    public String toString() {
        return "Exception occured: NotPrimeException";
    }
}

class Prime {
    int n;

    Prime(int x) {
        n = x;
    }

    void isPrime() throws NotPrimeException {
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                c++;
        }
        if (c != 0)
            throw new NotPrimeException(n);
        return;
    }
}

class NotTwinException extends Exception {
    private int n1, n2;

    NotTwinException(int x, int y) {
        n1 = x;
        n2 = y;
    }

    public String toString() {
        return "Exception occured: NotTwinException";
    }
}

class TwinPrime {
    int n1, n2;

    TwinPrime(int x, int y) {
        n1 = x;
        n2 = y;
    }

    void isTwinPrime() throws NotTwinException, NotPrimeException {
        Prime p1 = new Prime(n1);
        Prime p2 = new Prime(n2);
        if (n1 - n2 != 2 && n2 - n1 != 2)
            throw new NotTwinException(n1, n2);
        p1.isPrime();
        p2.isPrime();
    }
}

public class Question15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter numbers: ");
            TwinPrime t = new TwinPrime(sc.nextInt(), sc.nextInt());
            try {
                t.isTwinPrime();
                System.out.println("Twin Prime");
            } catch (NotPrimeException e1) {
                System.out.println(e1);
            } catch (NotTwinException e2) {
                System.out.println(e2);
            }
        }
        sc.close();
    }
}

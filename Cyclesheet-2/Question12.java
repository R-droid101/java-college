class Summation extends Thread {
    int marks[], freq[], low, high, sum;

    Summation(int[] m, int[] f, int l, int h) {
        marks = m;
        freq = f;
        low = l;
        high = h;
        sum = 0;
        start();
    }

    public void run() {
        for (int i = low; i < high; i++)
            sum += marks[i] * freq[i];
    }

    int getSum() {
        return sum;
    }
}

public class Question12 {
    public static void main(String[] args) {
        int marks[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int freq[] = { 3, 4, 17, 8, 23, 10, 4, 6, 5, 2 };
        int dummyMarks[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        int xf = 0, f = 0;
        double mean = 0;

        Summation xf1 = new Summation(marks, freq, 0, 5);
        Summation xf2 = new Summation(marks, freq, 5, 10);
        Summation f1 = new Summation(dummyMarks, freq, 0, 5);
        Summation f2 = new Summation(dummyMarks, freq, 5, 10);

        try {
            xf1.join();
            xf2.join();
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
        }

        xf = xf1.getSum() + xf2.getSum();
        f = f1.getSum() + f2.getSum();

        mean = 1.0 * xf / f;

        System.out.println("Mean is: " + mean);
    }
}

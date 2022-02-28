import java.util.*;

class Question5i {
    static void rotate(int size, int pos, String sqMat[]) { // method to rotate the matrix to the left according to the constraints
        int i, j;
        String first;
        for (i = 0; i < pos; i++) {
            first = sqMat[0];
            for (j = 0; j < size - 1; j++)
                sqMat[j] = sqMat[j + 1];
            sqMat[j] = first;
        }
    }

    static String[][] transpose(int size, String sqMat[][]) { // finding transpose of the matrix
        String transpose[][] = new String[size][size]; // variable to store transposed matrix
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                transpose[i][j] = sqMat[j][i];
        return transpose;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of matrix: ");
        int size = sc.nextInt();
        String sqMat[][] = new String[size][size];
        // reading elements of matrix
        System.out.println("Enter array elements: ");
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                sqMat[i][j] = sc.next();
        // rotating the array by the ith position towards left
        for (int i = 0; i < size; i++)
            rotate(size, i, sqMat[i]);
        sqMat = transpose(size, sqMat); // transposing for changing direction of rotation
        // rotating the array by the ith position towards left(upwards due to transpose)
        for (int i = 0; i < size; i++)
            rotate(size, i, sqMat[i]);
        sqMat = transpose(size, sqMat); // transposing to get the original array
        // printing the final matrix
        System.out.println("Final array:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(sqMat[i][j] + "\t");
            System.out.println();
            sc.close();
        }
    }
}

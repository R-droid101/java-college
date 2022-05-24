package mainpackage;

import parentpackage.childpackage.*;
import java.util.*;

public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();

        parentpackage.childpackage.ArrayBinaryTree aTree = new ArrayBinaryTree(n);
        parentpackage.childpackage.LinkedBinaryTree lTree = new LinkedBinaryTree(n);

        aTree.insert();
        lTree.insert();

        System.out.println("Array Tree:");
        aTree.traverse();
        System.out.println("LinkedList Tree:");
        lTree.traverse();
    }
}

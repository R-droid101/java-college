package parentpackage.childpackage;

import parentpackage.*;
import java.util.*;

public class LinkedBinaryTree implements BinaryTree {
    Node root;
    int n;
    Queue<Node> tree = new LinkedList<>();

    public LinkedBinaryTree(int a) {
        root = null;
        n = a;
    }

    public void insert() {
        tree.clear();
        root = new Node();
        root.data = "0";
        n--;
        tree.add(root);

        while (n > 0) {
            Node temp = tree.remove();
            temp.left = new Node();
            temp.left.data = temp.data + "0";
            tree.add(temp.left);
            n--;
            if (n == 0)
                break;
            temp.right = new Node();
            temp.right.data = temp.data + "1";
            tree.add(temp.right);
            n--;
        }
    }

    public void traverse() {
        tree.clear();
        tree.add(root);
        while (tree.peek() != null) {
            Node temp = tree.remove();
            System.out.println(temp.data);
            tree.add(temp.left);
            tree.add(temp.right);
        }
    }
}

class Node {
    Node left;
    Node right;
    String data;

    Node() {
        left = null;
        right = null;
        data = "";
    }
}

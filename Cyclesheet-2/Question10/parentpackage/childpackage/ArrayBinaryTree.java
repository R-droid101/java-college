package parentpackage.childpackage;

import parentpackage.*;

public class ArrayBinaryTree implements BinaryTree {
    String[] tree;

    public ArrayBinaryTree(int n) {
        tree = new String[n];
        tree[0] = "0";
    }

    public void insert() {
        for (int i = 1; i < tree.length; i++) {
            int parent;
            if (i % 2 == 0) {
                parent = (i - 2) / 2;
                tree[i] = tree[parent] + "1";
            } else {
                parent = (i - 1) / 2;
                tree[i] = tree[parent] + "0";
            }
        }
    }

    public void traverse() {
        for (String str : tree)
            System.out.println(str);
    }
}

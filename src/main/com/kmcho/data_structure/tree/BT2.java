package com.kmcho.data_structure.tree;

/**
 * How to determine if a binary tree is height-balanced?
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 */

public class BT2 {
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);


        n1.parentOf(n2, n3);
        n2.parentOf(n4, n5);
        n3.parentOf(n6, n7);
        n4.parentOf(n8, null);
        n6.parentOf(n9, null);
        n9.parentOf(n10, null);

        System.out.println("is Balanced = " + checkBalanced(n1));
    }

    public static boolean checkBalanced(Node n1) {
        int min = minDepth(n1);
        int max = maxDepth(n1);
        System.out.println("min depth = " + min);
        System.out.println("max depth = " + max);
        return (max - min) < 2 ? true : false;
    }

    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(root.getLeft()),
                minDepth(root.getRight()));
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

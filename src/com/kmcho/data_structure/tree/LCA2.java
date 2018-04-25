package com.kmcho.data_structure.tree;

/**
 * Lowest Common Ancestor in a Binary Tree
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */

public class LCA2 {
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

        System.out.println("is covered? = " + cover(n2, n8));
        System.out.println("first common = " + firstCommon(n1, n7, n10).value);
    }

    public static Node firstCommon(Node root, Node n1, Node n2) {
        if (cover(root.left, n1) && cover(root.left, n2)) {
            return firstCommon(root.left, n1, n2);
        } else if (cover(root.right, n1) && cover(root.right, n2)) {
            return firstCommon(root.right, n1, n2);
        }
        return root;
    }

    public static boolean cover(Node root, Node n1) {
        if (root == null) {
            return false;
        }
        if (root.value == n1.value) {
            return true;
        }
        return cover(root.left, n1) || cover(root.right, n1);
    }
}

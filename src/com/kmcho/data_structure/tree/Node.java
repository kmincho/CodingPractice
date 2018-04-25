package com.kmcho.data_structure.tree;

public class Node {
    public int value;
    public Node left = null;
    public Node right = null;

    public Node(int d) {
        value = d;
    }

    public void parentOf(Node l, Node r) {
        left = l;
        right = r;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}

package com.kmcho.data_structure.tree;

public class BST {
    public static void main(String[] args) {
        Node tree = null;
        int[] values = {2, 5, 3, 9, 8, 4, 6, 1, 2};
        for (int i = 0; i < values.length; i++) {
            tree = insert(tree, new Node(values[i]));
        }
        print(tree);
        System.out.println();
        search(tree, 11);


        int remove = 3;
        remove(tree, remove);
        System.out.println("removed " + remove);
        print(tree);
        System.out.println();
    }

    public static void remove(Node node, int value) {
        Node parent = null;
        Node current = node;

        while (current != null && current.value != value) {
            if (current.left == null && current.right == null) {
                current = null;
                break;
            }

            parent = current;
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current != null) {
            if (current.left == null && current.right == null) {
                if (parent.left == current) {
                    parent.left = null;
                } else if (parent.right == current) {
                    parent.right = null;
                }
            } else if (current.left == null) {
                if (parent.left == current) {
                    parent.left = current.right;
                } else if (parent.right == current) {
                    parent.right = current.right;
                }
            } else if (current.right == null) {
                if (parent.left == current) {
                    parent.left = current.left;
                } else if (parent.right == current) {
                    parent.right = current.left;
                }
            } else {
                Node leftMost = current.right;
                Node parentLeftMost = current;
                while (leftMost.left != null) {
                    parentLeftMost = leftMost;
                    leftMost = leftMost.left;
                }

                current.value = leftMost.value;
                if (leftMost == current.right) {
                    parentLeftMost.right = null;
                } else {
                    parentLeftMost.left = null;
                }
            }
        }
    }

    public static Node search(Node parent, int value) {
        if (parent == null) {
            System.out.println("cannot find parent : value = " + value);
            return null;
        }
        if (parent.value == value) {
            System.out.println("value from parent = " + parent.value);
            return parent;
        }
        if (value < parent.value) {
            parent = search(parent.left, value);
        } else {
            parent = search(parent.right, value);
        }
        return parent;
    }

    public static Node insert(Node parent, Node node) {
        if (parent == null) {
            parent = node;
        } else {
            if (node.value < parent.value) {
                parent.left = insert(parent.left, node);
            } else {
                parent.right = insert(parent.right, node);
            }
        }
        return parent;
    }

    public static void print(Node parent) {
        if (parent == null) {
            return;
        }

        print(parent.left);
        System.out.print(parent.value + " ");
        print(parent.right);
    }


    public static void inOrder(Node parent) {
        if (parent == null) {
            return;
        }
        inOrder(parent.left);
        System.out.println(parent.value);
        inOrder(parent.right);
    }

    public static void preOrder(Node parent) {
        if (parent == null) {
            return;
        }
        System.out.println(parent.value);
        preOrder(parent.left);
        preOrder(parent.right);
    }

    public static void postOrder(Node parent) {
        if (parent == null) {
            return;
        }
        postOrder(parent.left);
        postOrder(parent.right);
        System.out.println(parent.value);
    }
}



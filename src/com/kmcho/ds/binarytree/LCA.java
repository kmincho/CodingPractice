package com.kmcho.ds.binarytree;

public class LCA {
    public static void main(String[] args) {
        Node[] nodes = new Node[15];
        Node root = createTree(nodes);

        LCA(root, nodes[11], nodes[6]);
    }

    public static void LCA(Node node, Node a, Node b) {
        if (node.left != null) LCA(node.left, a, b);
        if (node.right != null) LCA(node.right, a, b);

        if (node.value == a.value || node.value == b.value) {
            node.found++;
        }

        if (node.left != null && node.left.found > 1
                || node.right != null && node.right.found > 1) return;

        if (node.left != null) node.found += node.left.found;
        if (node.right != null) node.found += node.right.found;

        if (node.found > 1) {
            System.out.println("LCA(" + a.value + ", " + b.value + ") = " + node.value);
            return;
        }

        return;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        int found = 0;

        public Node(int value) {
            this.value = value;
        }

        public void parentOf(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    private static Node createTree(Node[] nodes) {
        for (int i = 0; i < 15; i++) {
            nodes[i] = new Node(i);
        }

        nodes[0].parentOf(nodes[1], nodes[2]);
        nodes[1].parentOf(nodes[3], nodes[4]);
        nodes[2].parentOf(nodes[5], nodes[6]);
        nodes[3].parentOf(nodes[7], nodes[8]);
        nodes[4].parentOf(nodes[9], nodes[10]);
        nodes[5].parentOf(nodes[11], nodes[12]);
        nodes[6].parentOf(null, null);
        nodes[7].parentOf(nodes[13], nodes[14]);
        nodes[8].parentOf(null, null);
        nodes[9].parentOf(null, null);
        nodes[10].parentOf(null, null);
        nodes[11].parentOf(null, null);
        nodes[12].parentOf(null, null);
        nodes[13].parentOf(null, null);
        nodes[14].parentOf(null, null);

        return nodes[0];
    }
}

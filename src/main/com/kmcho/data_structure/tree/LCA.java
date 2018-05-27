package com.kmcho.data_structure.tree;

public class LCA {
    public static void main(String[] args) {
        Node[] nodes = new Node[15];

        Node root = createTree(nodes);
        Node a =  nodes[13];
        Node b = nodes[7];

        Node node = findLCA(root, a, b);

        System.out.println("LCA(" + a.value + ", " + b.value + ") = " + node.value);
    }

    public static Node findLCA(Node node, Node a, Node b) {
        if (node == null) {
            return null;
        }

        if (node.value == a.value || node.value == b.value) {
            return node;
        }

        Node leftLCA = findLCA(node.left, a, b);
        Node rightLCA = findLCA(node.right, a, b);

        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        return leftLCA != null ? leftLCA : rightLCA;
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

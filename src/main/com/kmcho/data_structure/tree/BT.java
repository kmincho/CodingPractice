package com.kmcho.data_structure.tree;

/**
 * How to determine if a binary tree is height-balanced?
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 */

public class BT {
    public static void main(String[] args) {

        Node root = createTree();

        System.out.println("balanced tree? " + isBalanced(root));
    }

    public static boolean isBalanced(Node node)  {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }

        if (!isBalanced(node.left) || !isBalanced(node.right)) {
            return false;
        }

        int heightLeft = getHeight(node.left);
        int heightRight = getHeight(node.right);
        if (heightLeft - heightRight > 1 || heightLeft - heightRight < -1) {
            return false;
        }

        return true;
    }

    public static int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }

        int heightLeft = getHeight(node.left);
        int heightRight = getHeight(node.right);

        return heightLeft > heightRight ? heightLeft + 1 : heightRight + 1;
    }

    private static Node createTree() {
        Node[] nodes = new Node[15];

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

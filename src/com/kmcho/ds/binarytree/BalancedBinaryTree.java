package com.kmcho.ds.binarytree;

public class BalancedBinaryTree {
    public static void main(String[] args) {

        TreeNode root = createTree();

        System.out.println("balanced tree? " + isBalanced(root));
    }

    public static boolean isBalanced(TreeNode node)  {
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

    public static int getHeight(TreeNode node) {
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

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public void set(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode createTree() {
        TreeNode[] nodes = new TreeNode[15];

        for (int i = 0; i < 15; i++) {
            nodes[i] = new TreeNode(i);
        }

        nodes[0].set(nodes[1], nodes[2]);
        nodes[1].set(nodes[3], nodes[4]);
        nodes[2].set(nodes[5], nodes[6]);
        nodes[3].set(nodes[7], nodes[8]);
        nodes[4].set(nodes[9], nodes[10]);
        nodes[5].set(nodes[11], nodes[12]);
        nodes[6].set(null, null);
        nodes[7].set(nodes[13], nodes[14]);
        nodes[8].set(null, null);
        nodes[9].set(null, null);
        nodes[10].set(null, null);
        nodes[11].set(null, null);
        nodes[12].set(null, null);
        nodes[13].set(null, null);
        nodes[14].set(null, null);

        return nodes[0];
    }
}

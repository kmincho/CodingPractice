package com.kmcho.alg;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
 */

public class WordLadder {
    static String[] vocabulary = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
    
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);
        String start = scanner.next();
        String end = scanner.next();

        Node node = new Node(start);
        Node root = addNodeAsChild(null, node);

        if (root != null) {
            node = findNode(root, end);
            findLength(node);
        } else {
            System.out.println("There are no adjacent nodes");
        }
    }

    static void findLength(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (node.getParent() != null) {
            node = node.getParent();
            stack.push(node);
        }

        System.out.println("length = " + stack.size());
        while (!stack.empty()) {
            System.out.println(stack.pop().getValue());
        }
    }

    static Queue<Node> queue = new LinkedList<>();

    static Node findNode(Node node, String keyword) {
        if (node.getValue().equals(keyword)) return node;

        List<Node> children = node.getChildren();
        if (children.size() > 0) {
            for (Node n : children) {
                queue.add(n);
            }
        }

        if (!queue.isEmpty()) {
            return findNode(queue.remove(), keyword);
        }

        return null;
    }

    static Node addNodeAsChild(Node node, Node candidate) {
        String value = candidate.getValue();

        if (node != null) {
            if (existInAncestor(node, value)) {
                return node;
            }

            node.addChild(candidate);
            candidate.setParent(node);
        }

        String[] childValues = findAdjacentWords(value);

        if (childValues.length == 0) {
            return node;
        }

        for (String v : childValues) {
            Node childCandidate = new Node(v);
            addNodeAsChild(candidate, childCandidate);
        }

        return candidate;
    }

    static boolean existInAncestor(Node node, String value) {
        if (node == null) return false;

        if (node.getValue().equals(value)) {
            return true;
        }

        return existInAncestor(node.getParent(), value);
    }

    static class Node {
        private String value;
        private Node parent;
        private List<Node> children = new ArrayList<>();

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getParent() {
            return this.parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChild(Node node) {
            children.add(node);
        }
    }

    static String[] findAdjacentWords(String keyword) {
        List<String> adjacentWords = new ArrayList<>();

        for (String word : vocabulary) {
            if (isAdjacentWord(word, keyword)) {
                adjacentWords.add(word);
            }
        }

//        return result.toArray(new String[0]);
        return adjacentWords.stream().toArray(String[]::new);
    }

    static boolean isAdjacentWord(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == second.charAt(i)) {
                count++;
            }
        }

        return count == first.length() - 1;
    }
}

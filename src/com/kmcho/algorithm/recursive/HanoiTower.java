package com.kmcho.algorithm.recursive;

/**
 * Tower of Hanoi
 * https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
 */

public class HanoiTower {

    public static void main(String[] args) {
        Stack stack1 = new Stack(1);
        Stack stack2 = new Stack(2);
        Stack stack3 = new Stack(3);

//     stack1.push(4);
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);

        moveDisk(3, stack1, stack3, stack2);
    }

    public static void moveTop(Stack from, Stack to) {
        to.push(from.pop().get());
        System.out.println("Move from " + from.id + " to " + to.id);
    }

    public static void moveDisk(int n, Stack from, Stack to, Stack buffer) {
        if (n < 1) {
            return;
        }
        moveDisk(n - 1, from, buffer, to);
        moveTop(from, to);
        moveDisk(n - 1, buffer, to, from);
    }

    private static class Node {
        int data;
        Node next;

        public Node(int value) {
            data = value;
        }

        public int get() {
            return data;
        }
    }

    private static class Stack {
        Node top;
        int id;

        public Stack(int i) {
            id = i;
        }

        public void push(int data) {
            Node node = new Node(data);
            node.next = top;
            top = node;
        }

        public Node pop() {
            if (top == null) {
                System.out.println("no more data in the stack");
                return null;
            }
            Node ret = top;
            top = top.next;
            return ret;
        }
    }
}

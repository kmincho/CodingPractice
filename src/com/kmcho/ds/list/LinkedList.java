package com.kmcho.ds.list;

import java.util.stream.IntStream;

/**
 * https://www.geeksforgeeks.org/linked-list-set-1-introduction/
 */

public class LinkedList<T> {
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        int[] values = {1, 3, 8, 2};

        LinkedList<Integer> list = new LinkedList<>();

        IntStream.of(values).forEach(v -> list.add(v));
        System.out.println(list.toString());

        try {
            list.remove(8);
            System.out.println(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        }

        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void remove(T value) throws Exception {
        Node current = head;

        if (current == null) {
            throw new Exception("list is empty");
        }

        Node next = current.next;

        while (next != null) {
            if (next.value == value) {
                current.next = next.next;
                return;
            }
            current = next;
            next = current.next;
        }
        throw new Exception("cannot find the value");
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        Node next = head;
        builder.append("[");
        while (next != null) {
            builder.append(next.value);
            next = next.next;
            if (next != null) {
                builder.append(", ");
            }
        }
        builder.append("]");

        return builder.toString();
    }
}

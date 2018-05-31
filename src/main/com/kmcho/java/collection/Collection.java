package com.kmcho.java.collection;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
        arrayListPractice();
        vectorPractice();
    }
    
    private static void arrayListPractice() {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 8, 7, 6));

        al.add(9);

        printList1(al);
        printList2(al);
        printList3(al);
        printList4(al);
    }

    private static void vectorPractice() {
        Vector v = new Vector(Arrays.asList(1, 2, "Tiger"));
        v.add(5);
        v.add("Lion");

        printList3(v);
        System.out.println("element (idx = 2) in vector = " + v.get(2));
        System.out.println("vector size = " + v.size());
        System.out.println("vector capacity = " + v.capacity());
    }

    private static void printList1(List<Integer> al) {
        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next());
            if (itr.hasNext()) System.out.print(", ");
        }
        System.out.println();
    }

    private static void printList2(List<Integer> al) {
        for (Integer n : al) {
            System.out.print(n + ", ");
        }
        System.out.println();
    }

    private static void printList3(List<Integer> al) {
        System.out.println(al);
    }

    private static void printList4(List<Integer> al) {
        al.forEach(System.out::println);
    }
}

package com.kmcho.java.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PrintList {
    public static void printList1(List<Integer> al) {
        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next());
            if (itr.hasNext()) System.out.print(", ");
        }
        System.out.println();
    }

    public static void printList2(List<Integer> al) {
        for (Integer n : al) {
            System.out.print(n + ", ");
        }
        System.out.println();
    }

    //the most simplest way
    public static void printList3(List<Integer> al) {
        System.out.println(al);
    }

    public static void printList4(List<Integer> al) {
        al.forEach(System.out::println);

    }

    public static void printList5(List<Integer> al) {
        System.out.println(Arrays.toString(al.toArray()));
    }
}

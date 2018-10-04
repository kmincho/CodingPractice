package com.kmcho.java.collection;

import java.util.*;

import static com.kmcho.java.collection.PrintList.*;

public class MakeList {
    public static void main(String[] args) {
        arrayListPractice();
    }
    
    private static void arrayListPractice() {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 8, 7, 6));

        al.add(9);

        printList1(al);
        printList2(al);
        printList3(al);
        printList4(al);
        printList5(al);
    }
}

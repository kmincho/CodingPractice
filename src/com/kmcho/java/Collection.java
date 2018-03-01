package com.kmcho.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection {
    public static void main(String[] args) {
        ArrayListPractice();
    }
    
    public static void ArrayListPractice() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(3);
        al.add(2);
        al.add(4);
        al.add(8);
        al.add(7);
        al.add(6);
        Iterator<Integer> itr = al.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }
        
        for (Integer n : al) {
            System.out.println(n);
        }
    }
}

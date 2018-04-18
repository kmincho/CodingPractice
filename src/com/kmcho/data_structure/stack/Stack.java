package com.kmcho.data_structure.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private ArrayList<T> data = new ArrayList<>();

    public void push(T value) {
        data.add(value);
    }

    public T pop() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("pop: stack is empty");
        }

        return data.remove(data.size() - 1);
    }

    public T peek() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("peek: stack is empty");
        }

        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int index = data.size();

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            if (index < 0) {
                throw new NoSuchElementException("next: no more data");
            }
            return data.get(index);
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(6);
        stack.push(3);
        stack.push(9);
        System.out.println(stack.peek());
        System.out.println();

        while (!stack.isEmpty()) {
            Integer data = stack.pop();
            System.out.println(data);
        }
        System.out.println();

        stack.push(11);
        stack.push(16);
        stack.push(13);
        stack.push(19);
        System.out.println(stack.peek());
        System.out.println();

        Iterator<Integer> iterator = stack.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }



}

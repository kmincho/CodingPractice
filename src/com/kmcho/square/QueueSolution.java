package com.kmcho.square;
/*
 * Square Interview Coding Questions:
 * Implement a queue from scratch (cannot use a built in one)
 */

public class QueueSolution {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.showAll();
		q.dequeue();
		q.dequeue();
		q.showAll();
		q.enqueue(5);
		q.showAll();
	}
}

class Queue<T> {
	NodeQueue<T> head;
	NodeQueue<T> tail;
	
	public Queue() {
		head = null;
		tail = null;
	}
	
	public void enqueue(T a) {
		NodeQueue<T> node = new NodeQueue<T>(a);
		if (head == null) {
			head = node;
			tail = node;
		}
		tail.next = node;
		tail = node;
	}
	
	public T dequeue() {
		NodeQueue<T> ret = head;
		head = head.next;
		return ret.value;
	}
	
	public void showAll() {
		NodeQueue<T> curNode = head;
		StringBuilder str = new StringBuilder();
		while(curNode != null) {
			str.append(curNode.value);
			curNode = curNode.next;
			if (curNode != null) {
				str.append(" -> ");
			}
		}
		System.out.println(str.toString());
	}
}

class NodeQueue<T> {
	T value;
	NodeQueue<T> next;
	public NodeQueue(T a) {
		value = a;
		next = null;
	}
}

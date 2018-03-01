package com.kmcho.square;
/*
 * Square Interview Coding Questions:
 * Write the calculate function
 */

public class CalculateFunc {
	public static void main(String[] args) {
		System.out.println("result = " + calculate("2 3 +"));
		System.out.println("result = " + calculate("12 2 /"));
		System.out.println("result = " + calculate("48 4 6 * /"));
	}
	
	public static String calculate(String input) {
		final String operators = "+-*/";
		String[] tokens = input.split(" ");
		Stack<String> stack = new Stack<String>();
		//showTokens(tokens);
		float v1 = 0;
		float v2 = 0;
		float v3 = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (!operators.contains(tokens[i])) {
				stack.push(tokens[i]);
			} else {
				v1 = Float.valueOf(stack.pop());
				v2 = Float.valueOf(stack.pop());
				if ("+".equals(tokens[i])) {
					v3 = v2 + v1;
				} else if ("-".equals(tokens[i])) {
					v3 = v2 - v1;
				} else if ("*".equals(tokens[i])) {
					v3 = v2 * v1;
				} else if ("/".equals(tokens[i])) {
					v3 = v2 / v1;
				}
				stack.push(String.valueOf(v3));
				
			}
		}
		return stack.pop();
	}

	public static void showTokens(String[] str) {
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
}

class Stack<T> {
	NodeStack<T> top;
	
	public Stack() {
		top = null;
	}
	public void push(T a) {
		NodeStack<T> node = new NodeStack<T>(a);
		node.next = top;
		top = node;
	}
	
	public T pop() {
		NodeStack<T> ret = top;
		top = top.next;
		return ret.value;
	}
}

class NodeStack<T> {
	T value;
	NodeStack<T> next;
	public NodeStack(T v) {
		value = v;
	}
}

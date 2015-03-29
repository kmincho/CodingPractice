public class InOrderTreeIterator {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		
		inOrderTraverse(n1);
	}
	
	public static void inOrderTraverse(Node n) {
		if (n == null) {
			return;
		}
		inOrderTraverse(n.left);
		System.out.println(n.value);
		inOrderTraverse(n.right);
	}
}

class Node {
	public int value;
	public Node left = null;
	public Node right = null;
	
	public Node(int v) {
		value = v;
	}
}

package square;
/*
 * Square Interview Coding Questions:
 * LRU cache problem that supports get and set operations
 */

import java.util.HashMap;

public class LRUCacheSolution {
	public static void main(String[] args) {
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(5);
		cache.set(1, 1);
		System.out.println(cache.printLinkedList());
		cache.set(2, 2);
		System.out.println(cache.printLinkedList());
		cache.set(3, 3);
		System.out.println(cache.printLinkedList());
		cache.get(1);
		System.out.println(cache.printLinkedList());
		cache.set(4, 4);
		System.out.println(cache.printLinkedList());
		cache.set(5, 5);
		System.out.println(cache.printLinkedList());
		cache.set(6, 6);
		System.out.println(cache.printLinkedList());
		cache.set(7, 7);
		System.out.println(cache.printLinkedList());
		cache.set(8, 8);
		System.out.println(cache.printLinkedList());
		cache.get(6);
		System.out.println(cache.printLinkedList());
		cache.get(4);
		System.out.println(cache.printLinkedList());
		cache.get(7);
		System.out.println(cache.printLinkedList());
		cache.get(8);
		System.out.println(cache.printLinkedList());
		cache.set(1, 1);
		System.out.println(cache.printLinkedList());
	}
	

}

class LRUCache<T1, T2> {
	int maxSize;
	HashMap<T1, T2> mMap = null;
	LLNode<T1> mLinkedList = null;
	
	public LRUCache(int size) {
		maxSize = size;
		mMap = new HashMap<T1, T2>();
		mLinkedList = new LLNode<T1>();
	}
	
	public T2 get(T1 key) {
		if (mLinkedList.findNode(key) == null) {
			System.out.println("cannot find key : " + key);
			return null;
		}
		mLinkedList.findNode(key).moveToTail();
		return mMap.get(key);
	}
	
	public void set(T1 key, T2 value) {
		if (mMap.size() >= maxSize) {
			mMap.remove(mLinkedList.key);
			mLinkedList = mLinkedList.removeHead(mLinkedList);
		}
		mMap.put(key, value);
//		mLinkedList = mLinkedList.addToHead(mLinkedList, key);
		mLinkedList.addToTail(key);
	}
	
	public String printLinkedList() {
		return mLinkedList.printLinkedList(mLinkedList);
	}
}

class LLNode<T> {
	public T key;
	public LLNode<T> next;
	
	public LLNode() {
		key = null;
		next = null;
	}
	
	public LLNode(T k) {
		key = k;
	}

	public LLNode<T> addToHead(LLNode<T> head, T k) {
		if (head.key == null) {
			head.key = k;
			next = null;
			return head;
		}
		LLNode<T> node = new LLNode<T>(k);
		node.next = head;
		return node;
	}
	
	public String printLinkedList(LLNode<T> head) {
		LLNode<T> curNode = head;
		StringBuffer str = new StringBuffer();
		while(curNode != null) {
			str.append(curNode.key);
			curNode = curNode.next;
			if (curNode != null) {
				str.append(", ");
			}
		}
		return str.toString();
	}
	
	public LLNode<T> removeHead(LLNode<T> head) {
		LLNode<T> newHead = head.next;
		return newHead;
	}
	
	public void addToTail(T k) {
		if (key == null) {
			key = k;
			next = null;
			return;
		}
		LLNode<T> node = new LLNode<T>(k);
		LLNode<T> curNode = this;
		while(curNode.next != null) {
			curNode = curNode.next;
		}
		curNode.next = node;
	}
	
	public LLNode<T> findNode(T key) {
		LLNode<T> curNode = this;
		while (curNode != null) {
			if (curNode.key == key) {
				return curNode;
			}
			curNode = curNode.next;
		}
		return null;
	}
	
//	public LLNode<T> moveToHead(LLNode<T> head) {
//		LLNode<T> nHead = new LLNode<T>(this.key);
//		nHead.key = this.key;
//		nHead.next = head;
//		
//		if (next != null) {
//			key = next.key;
//			next = next.next;
//		}
//		
//		return nHead; 
//	}
	
	public void moveToTail() {
		addToTail(this.key);
		this.key = next.key;
		this.next = next.next;
	}
}

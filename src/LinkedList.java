/*
   File: LinkedList.java
   Author: Caleb Bitting
   Date: 09/22/2020
   LinkedList Class
*/


import java.util.Iterator;    // defines the Iterator interface
import java.util.ArrayList;   
import java.util.Collections; // contains a shuffle function

public class LinkedList<T> implements Iterable<T>{
	
	@SuppressWarnings("unused")
	private class Node {
		
		Node next;
		T data;
		
		public Node (T item) {
			next = null;
			data = item;
		}
		
		public T getData() {
			return this.data;
		}
		
		public void setNext(Node n) {
			this.next = n;
		}
		
		public Node getNext() {
			return next;
		}
		
		public String toString() {
			return data.toString();
		}
		
	}
	
	private class LLIterator implements Iterator<T> {
		
		Node field;
		
		public LLIterator(Node head) {
			field = head;
		}
		
		@SuppressWarnings("unused")
		public boolean hasNext() {
			try {
				boolean foo = field.next == null;
				return true;
			} catch (NullPointerException ex){
				return false;
			}
			
		}
		
		public T next() {
			T toReturn = field.data;
			field = field.next;
			return toReturn;
		}
		
		public void remove() {}
		
	}
	
	Node top;
	int size;
	
	public LinkedList() {
		top = null;
		size = 0;
	}
	
	public boolean contains(T obj) {
		boolean toReturn = false;
		for (T item : this) {
			if (item.equals(obj)) {
				toReturn = true;
			}
		}
		
		return toReturn;
	}
	
	public int getSize() {
		return size;
	}
	
	public void reverse() {
		Node next = null, previous = null;
		Node current = top;
		
		while (current != null) {		
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		top = previous;
		
	}
	
	public String toString() {
		String toReturn = "<";
		for (T item : this) {
			toReturn += item.toString();
			toReturn += ", ";
		}
		toReturn = toReturn.substring(0, toReturn.length() - 2);
		toReturn += ">";
		return toReturn;
	}
	
	public void replaceSecondValue(T newValue) {
		if (!(this.size() >= 2)) {
			return;
		} else {
			this.insert(1, newValue);
			this.remove(2);
		}
	}
	
	public void clear() {
		top = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(T item) {
		Node foo = new Node(item);
		if (size++ != 0) {
			foo.next = top;
		}
		top = foo;
	}
	
	public void addLast(T item) {
		this.insert(size, item);
	}
	
	public void insert(int index, T item) {
		if (index == 0) {
			this.addFirst(item);
		} else {
			// create data Node and pointer Node
			Node foo = new Node(item);
			Node temp = top;
			// find the Node immediately before the new Node's final place
			int tempIndex = 0;
			while (tempIndex != index - 1) {
				temp = temp.next;
				tempIndex++;
			}
			// set the new Node to point at the Node that the Node immediately before the new Node's final place is currently pointing at
			foo.next = temp.next;
			// set the Node immediately before the new Node to point at the new Node
			temp.next = foo;
			size++;
		}
	}
	
	public void remove(int index) {
		if (index == 0) {
			top = top.next;
			size--;
		} else {
			// create pointer Node and pointer index
			Node temp = top;
			int tempIndex = 0;
			// find the Node immediately preceding the doomed one
			while (tempIndex != index - 1) {
				temp = temp.next;
				tempIndex++;
			}
			temp.next = temp.next.next;
			size--;
		}
		
	}
	
	public ArrayList<T> toArrayList() {
		ArrayList<T> foo = new ArrayList<T>();
		for (T item : this) {
			foo.add(item);
		}
		return foo;
	}
	
	public ArrayList<T> toShuffledList() {
		ArrayList<T> foo = this.toArrayList();
		Collections.shuffle(foo);
		return foo;
	}
	
	public Iterator<T> iterator() {
		    return new LLIterator(this.top);
	}
	
	public boolean equals(LinkedList<T> other) {
		boolean toReturn = true;
		// check for the same size
		if (this.getSize() != other.getSize()) {
			toReturn = false;
		} else {
			// iterate over the lists together
			Iterator<T> thisIter = this.iterator();
			Iterator<T> otherIter = other.iterator();
			while(thisIter.hasNext()) {
				// if the next item in both queues are not the same, trip the switch
				if (!(thisIter.next().equals(otherIter.next()))) {
					toReturn = false;
				}
			}
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> lst = new LinkedList<Integer>();
		lst.addFirst(1);
		lst.addFirst(2);
		lst.addFirst(3);
		System.out.println(lst.contains(1));	// expect true
		System.out.println(lst.contains(4));	// expect false
		System.out.println();
		System.out.println(lst);				// expect <3, 2, 1>
		System.out.println();
		lst.replaceSecondValue(4);
		System.out.println(lst);				// expect <3, 4, 1>
		System.out.println();
		lst.reverse();
		System.out.println(lst);				// expect <1, 4, 3>
	}
	

}

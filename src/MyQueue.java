import java.util.ArrayList;
import java.util.Iterator;

public class MyQueue<T> implements Iterable<T>{
	
	// helper classes
	private class Node {
		private Node next, prev;
		private T val;
		
		// constructor
		public Node(T val) {
			next = null;
			prev = null;
			this.val = val;
		}
		
		// accessors and mutators
		public Node getNext() {
			return this.next;
		}
		
		@SuppressWarnings("unused")
		public Node getPrev() {
			return this.prev;
		}
		
		public T getVal() {
			return this.val;
		}
		
		public void setNext(Node foo) {
			this.next = foo;
		}
		
		public void setPrev(Node foo) {
			this.prev = foo;
		}
	}

	private class QIterator implements Iterator<T> {
		private Node current;
		
		// constructor
		public QIterator(Node head) {
			current = head;
		}
		
		// interface methods
		public boolean hasNext() {
			if (current != null) {
				return true;
			} else {
				return false;
			}
		}
		
		public T next() {
			if (this.hasNext()) {
				T foo = current.getVal();
				current = current.getNext();
				return foo;
			} else {
				return null;
			}
		}
	}
	
	private Node head, tail;
	private int size;
	
	// constructor
	public MyQueue() {
		head = null;
		tail = null;
		size = 0;		
	}
	
	// accessors and mutators
	public Node getHead() {
		return this.head;
	}
	
	public Node getTail() {
		return this.tail;
	}
	
	public int getSize() {
		return size;
	}
	
	// utility methods
	public boolean offer(T val) {
		Node foo = new Node(val);
		// if there isn't any values
		if (size++ == 0) {
			head = foo;
			tail = foo;
			return true;
		} else {
			// make sure that linkages are correct
			foo.setPrev(tail);
			tail.setNext(foo);
			tail = foo;
			return true;
		}
	}
	
	public T poll() {
		T toReturn;
		if (size == 0) {
			toReturn = null; 
		} else if (size == 1) {
			toReturn = head.getVal();
			head = null;
			tail = null;
		} else {
			toReturn = head.getVal();
			head = head.getNext();
			head.setPrev(null);		// make sure that the new head Node doesn't point anywhere else
		}
		size--;
		return toReturn;
	}
	
	public T peak() {
		if (head == null) {
			return null;
		}
		return head.getVal();
	}
	
	public ArrayList<T> toArrayList() {
		ArrayList<T> toReturn = new ArrayList<T>();
		for (T val : this) {
			toReturn.add(val);
		}
		
		return toReturn;
	}
	
	public boolean equals(MyQueue<T> other) {
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
	
	// interface method
		public Iterator<T> iterator() {
			return new QIterator(this.head);
		}
	
	// usurper method
	public String toString() {
		String toReturn = "<";
		for (T val : this) {
			toReturn += val;
			toReturn += ", ";
		}
		toReturn = toReturn.substring(0, toReturn.length() - 2);
		toReturn += ">";
		return toReturn;
	}

}

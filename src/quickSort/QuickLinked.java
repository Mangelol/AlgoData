package quickSort;

import java.util.*;
public class QuickLinked {
	static class Node {
		int value;
		Node next;
		
		Node(int d){
			this.value = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void addNode(int value) {
		if(head == null) {
			head = new Node(value);
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		
		Node newNode = new Node(value);
		current.next = newNode;
	}
	
	void print(Node n) {
		while( n != null) {
			System.out.print(n.value);
			System.out.print(" ");
			n = n.next;
		}
	}
	
	Node partition(Node first, Node last) {
		if(first == last || first == null || last == null) {
			return first;
		}
		
		Node pivotPrev = first;
		Node current = first;
		int pivot = last.value;
		
		while(first != last) {
			if(first.value < pivot) {
				pivotPrev = current;
				int temp = current.value;
				current.value = first.value;
				first.value = temp;
				current = current.next;
			}
			first = first.next;
		}
		
		int temp = current.value;
		current.value = pivot;
		last.value = temp;
		
		return pivotPrev;
	}
	
	void linkedSort(Node first, Node last) {
		if(first == null || first == last || first == last.next) {
			return;
		}
		
		Node pivotPrev = partition(first, last);
		linkedSort(first, pivotPrev);
		
		if(pivotPrev != null && pivotPrev == first) {
			linkedSort(pivotPrev.next, last);
		}
		
		else if(pivotPrev != null && pivotPrev.next != null) {
			linkedSort(pivotPrev.next.next, last);
		}
	}
	
	public static void main(String[] args) {
		QuickLinked list = new QuickLinked();
		
		Random rnd = new Random(1000);

		list.addNode(5);
		list.addNode(23);
		list.addNode(8);
		list.addNode(35);
		list.addNode(1);
		list.addNode(18); 
		
		
		Node n = list.head;
		while(n.next != null) {
			n = n.next;
		}
		
		System.out.println("before sort ");
		list.print(list.head);
		
		long t1 = System.nanoTime();
		list.linkedSort(list.head, n);
		long t2 = System.nanoTime() - t1;
		System.out.println();
		System.out.println("Runtime " + t2);
		
		System.out.println("after sort ");
		list.print(list.head);
	}
	
}

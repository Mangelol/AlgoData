package heap;

public class LinkedListPrioAdd{
	Node first;
	Node last;
	
	public void add(int value) {
		Node newNode = new Node(value, null);
		if(first == null) {
			first = newNode;
			last = newNode;
		}
		else {
			last.next = newNode;
			last = last.next;
		}
	}
	
	public int remove() {
		if(first == null) {
			return 0;
		}
		else if(first.next == null) {
			int tmp = first.value;
			first = null;
			return tmp;
		}
		
		Node prev = first;
		Node smallest = first;
		Node current = first;
		
		while(current.next!= null) {
			if(current.next.value < smallest.value) {
				prev = current;
				smallest = current.next;
			}
			current = current.next;
		}
		if(smallest == first) {
			first = first.next;
		}
		else {
			prev.next = smallest.next;
			smallest.next = null;
		}
		return smallest.value;
	}
}
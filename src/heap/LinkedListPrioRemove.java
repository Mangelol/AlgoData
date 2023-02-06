package heap;

public class LinkedListPrioRemove {
	Node first;
	Node last;
	
	public void add(int value) {
		Node newNode = new Node(value, null);
		if(first == null) {
			first = newNode;
			last = newNode;
			return;
		}
		
		if(first.next == null) {
			if(value < first.value) {
				Node tmp = first;
				first = newNode;
				first.next = tmp;
			}
			else {
				first.next = newNode;
			}
			last = first.next;
			return;
		}
		
		if(first.value > value) {
			newNode.next = first;
			first = newNode;
			return;
		}
		
		Node current2 = first;
		while(current2.next != null) {
			if(current2.value <= value && current2.next.value >= value) {
				newNode.next = current2.next;
				current2.next = newNode;
				return;
			}
			current2 = current2.next;
		}
		last.next = newNode;
		last = newNode;
	}
	
	public int remove() {
		if(first == null) {
			return 0;
		}
		int tmp = first.value;
		first = first.next;
		return tmp;
	}
}

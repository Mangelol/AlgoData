package queue;

public class Queue {
	Node head;
	Node ultimo;
	
	public class Node{
		public BinaryTree.Node binaryNode;
		public Node tail;
		
		public Node(BinaryTree.Node item, Node list) {
			this.binaryNode = item;
			this.tail = list;
		}
	}
	
	public Queue() {
		head = null;
		ultimo = null;
		
	}
	
	public void add(BinaryTree.Node binaryNode) {
		if(head == null) {
			Node first = new Node(binaryNode, null); 
			head = first;
			ultimo = first;
		}
		
		else {
			ultimo.tail = new Node(binaryNode, null);
			ultimo = ultimo.tail;
		}
	}
	
	public BinaryTree.Node remove() {
		Node temp = head;
		head = head.tail;
		return temp.binaryNode;
	}
}

package heap;

public class TreeHeap {
	Node root;
	
	class Node {
		int value;
		Node left;
		Node right;
		int nmbNodesSubT;
		
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
			nmbNodesSubT = 1;
		}
		
		public void print() {
			System.out.println("\tvalue: " + value);
			
			if(left != null) {
				left.print();
			}
			if(right != null) {
				right.print();
			}
		}
		
		Integer add(Integer value) {
			if(value < this.value) {
				Integer tmp = this.value;
				this.value = value;
				value = tmp;
			}
			this.nmbNodesSubT += 1;
			if(this.left == null) {
				this.left = new Node(value);
				return 1;
			}
			else if(this.right == null) {
				this.right = new Node(value);
				return 1;
			}
			else {
				Integer d = this.right.add(value);
				Node tmp = this.right;
				this.right = this.left;
				this.left = tmp;
				return d + 1;
			}
		}
		
		private Node remove() {
			if(this.left == null) {
				return this.right;
			}
			else if(this.right == null) {
				return this.left;
			}
			else if(this.left.value < this.right.value) {
				this.value = this.left.value;
				this.left = this.left.remove();
			}
			else {
				this.value = this.right.value;
				this.right = this.right.remove();
			}
			this.nmbNodesSubT -= 1;
			return this;
		}
	}
	public Integer enqueue(Integer prio) {
		if(root != null) {
			return root.add(prio);
		}
		root = new Node(prio);
		return 0;
	}
		
	public void print() {
		root.print();
	}
	
	public void push(Integer increment) {
		Integer tmp = root.value;
		dequeue();
		enqueue(tmp + increment);
	}
	
	Integer dequeue() {
		if(root != null) {
			Integer ret = root.value;
			root = root.remove();
			return ret;
		}
		else {
			return null;
		}
	}
	
	static int returnDepth(Node root, int d) {
		if(root == null) {
			return -1;
		}
		if(root.data == d) || (dist = returnDepth(root.left, d)) >= 0 || (dist = returnDepth(root.right, d)) >= 0) {
			return dist + 1;
		}
		
		return dist;
	}

}

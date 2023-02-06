package queue;
import java.util.Iterator;

public class QueueIterator implements Iterator<Integer> {
	private BinaryTree.Node next;
	private Queue stack;
	
	public QueueIterator(BinaryTree.Node root) {
		stack = new Queue();
		stack.add(root);
	}
	
	@Override
	public boolean hasNext() {
		return !(stack.head == null);
	}
	
	@Override
	public Integer next() {
		if(hasNext()) {
			if(stack.head.binaryNode.left != null) {
				stack.add(stack.head.binaryNode.left);
			}
			if(stack.head.binaryNode.right != null) {
				stack.add(stack.head.binaryNode.right);
			}
		}
		
		return stack.remove().key;
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}

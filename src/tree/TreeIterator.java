package tree;

import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    private BinaryTree.Node next;
    private TreeStack<BinaryTree.Node> stack;
    
    public TreeIterator(BinaryTree.Node root) {
    	stack = new TreeStack();
    	this.next = root;
    	stack.push(next);
    	
    	while(next.left != null) {
    		stack.push(next.left);
    		next = next.left;
    	}
    }
    
    @Override
    public boolean hasNext() {
    	return !(stack.first == null);
    }
    @Override
    public Integer next() {
    	if (hasNext()) {
    		BinaryTree.Node popedNode = stack.pop();
    		if (popedNode.right != null) {
    			stack.push(popedNode.right);
    			BinaryTree.Node temp = popedNode.right;
    			while (temp.left != null) {
    	    		stack.push(temp.left);
    	    		temp = temp.left;
    	    	}
    		}
    		return popedNode.key;
    	}
    	return null;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

public class TreeStack<T> {
    private TreeStackNode stack;

    public class TreeStackNode {
        public TreeStackNode next;
        public BinaryTree.Node treeNode;

        public TreeStackNode(BinaryTree.Node nd, TreeStackNode next) {
            this.treeNode = nd;
            this.next = next;
        }
    }


    public void push(BinaryTree.Node nd) {
        this.stack = new TreeStackNode(nd, this.stack);
    }

    public BinaryTree.Node pop() {
        if (this.stack == null) {
            System.out.println("Stack is empty");
            return null;
        }
        BinaryTree.Node ret = stack.treeNode;
        stack = stack.next;
        return ret;
    }
}
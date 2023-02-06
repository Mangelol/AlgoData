package tree;

public class TreeStack<T> {
    public TreeStackNode first;

    public class TreeStackNode {
        public TreeStackNode next;
        public BinaryTree.Node treeNode;

        public TreeStackNode(BinaryTree.Node nd, TreeStackNode next) {
            this.treeNode = nd;
            this.next = next;
        }
    }


    public void push(BinaryTree.Node nd) {
        this.first = new TreeStackNode(nd, this.first);
    }

    public BinaryTree.Node pop() {
        if (this.first == null) {
            System.out.println("Stack is empty");
            return null;
        }
        BinaryTree.Node ret = first.treeNode;
        first = first.next;
        return ret;
    }
}

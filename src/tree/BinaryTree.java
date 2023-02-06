package tree;
import java.util.Iterator;

public class BinaryTree implements Iterable<Integer>  {


        public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {

            System.out.println(" key: " + key + "   \tvalue: " + value);

            if(left != null)
                left.print();

            if(right != null)
                right.print();
        }
    }

    Node root;
    public BinaryTree() {
        root = null;
    }
    public Iterator<Integer> iterator() {
        return new TreeIterator(root);
    }

    public void add(Integer key, Integer value){
        Node addNode = new Node(key, value);

        if(root == null){
            root = addNode;
        }
        else{
            Node currentNode = root;
            Node parent;

            while (true){
                parent = currentNode;
                if (key < currentNode.key){
                    currentNode = currentNode.left;

                    if(currentNode == null){
                        parent.left = addNode;
                        return;
                    }

                }
                else if(key > currentNode.key){
                    currentNode = currentNode.right;

                    if(currentNode == null){
                        parent.right = addNode;
                        return;
                    }

                }
                else {
                    currentNode.value = addNode.value;
                    return;
                }
            }
        }
    }

    public Integer lookup(Integer key){
        Node currentNode = root;
        while(currentNode.key != key){

            if (key < currentNode.key){
                currentNode = currentNode.left;
            }
            else{
                currentNode = currentNode.right;
            }
            if(currentNode == null)
                return null;
        }
        return currentNode.value;
    }
}
package linkedLists;

public class DynamicStack {
    private LinkedList top;

    public void push(int value) {
        LinkedList newValue = new LinkedList(value, top);
        top = newValue;
    }

    public int pop() {
        if(top == null) {
            System.out.println("The stack is empty");
            return 0;
        }

        int temp = top.head;
        top = top.tail;
        return temp;
    }
}

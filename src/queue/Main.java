package queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);
        for (int i : tree)
            System.out.println("next value " + i);
	
	 ArrayQueue arrayQueue = new ArrayQueue();
	
	for(int i = 0; i < 8; i++) {
		arrayQueue.add(i);
	}
	
	System.out.println(arrayQueue.remove());
	System.out.println(arrayQueue.remove());
	System.out.println(arrayQueue.remove());
	
	for(int i = 0; i < 8; i++) {
		System.out.println(arrayQueue.remove());
	} 
	/*
	DynamicArrayQueue dynamicArrayQueue = new DynamicArrayQueue();
	
	for(int i = 0; i < 5; i++) {
		dynamicArrayQueue.add(i);
	}
	
    System.out.println(dynamicArrayQueue.remove());
    System.out.println(dynamicArrayQueue.remove());
    System.out.println(dynamicArrayQueue.remove());
    
    for(int i = 0; i < 8; i++) {
    	dynamicArrayQueue.add(i + 5);
    }
    
    for(int i = 0; i < 10; i++) {
    	System.out.println(dynamicArrayQueue.remove());
    }
	
    System.out.println("Stack capacity " + dynamicArrayQueue.capacity); */
	
	} 
}

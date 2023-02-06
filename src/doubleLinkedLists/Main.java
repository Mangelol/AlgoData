package doubleLinkedLists;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList filledLinkedList = singleList(3);
		System.out.println(filledLinkedList.toString());
		
		DoubleLinkedList filledDouble = doubleList(3);
		filledDouble.printList();
		
		
//		DoublyLinked node1 = new DoublyLinked(5, null, null);
//		DoublyLinked node2 = new DoublyLinked(15, null, null);
//		DoublyLinked node3 = new DoublyLinked(25, null, null);
//		DoublyLinked node4 = new DoublyLinked(35, null, null );
//		DoublyLinked node5 = new DoublyLinked(45, null, null);
	//	
	//	
//		node1.append(node2);
//		node2.append(node3);
//		node1.append(node4);
//		node1.append(node5);
	//	
	//	
////		Add First test
//		System.out.println("Första " + node1.head + " " + node1.prev);
//		System.out.println("Andra " + node1.next.head + " " + node1.next.prev.head);
//		System.out.println("Tredje " + node1.next.next.head + " " + node1.next.next.prev.head);
//		node1.add(4);
//		System.out.println("Första " + node1.head + " " + node1.prev);
//		System.out.println("Andra " + node1.next.head + " " + node1.next.prev.head);
//		System.out.println("Tredje " + node1.next.next.head + " " + node1.next.next.prev.head);
//		System.out.println("Fjärde " + node1.next.next.next.head + " " + node1.next.next.next.prev.head);

//		Remove last test
//		System.out.println( "Sista "+  node1.next.next.next.next.head + " ligger i " + node1.next.next.next.next);
//		node1.remove(45);
//		System.out.println( "Sista ligger i " + node1.next.next.next.next);

//		Remove first test
//		System.out.println("Första " + node1.head 
//		System.out.println("Andra " + node1.next.head + " " + node1.next.prev.head );
//		node1.remove(5);
//		System.out.println("Första " + node1.head);
//		System.out.println("Andra " + node1.next.head);
//		node1.remove(25);
//		System.out.println("Första " + node1.head );
//		System.out.println("Andra " + node1.next.head );
//		node1.remove(15);
//		System.out.println("Första " + node1.head );
//		System.out.println("Andra " + node1.next.head );

//		LinkedList singelNode1 = new LinkedList(5, null);
//		LinkedList singelNode2 = new LinkedList(15, null);
//		LinkedList singelNode3 = new LinkedList(25, null);
//		LinkedList singelNode4 = new LinkedList(35, null);
//		LinkedList singelNode5 = new LinkedList(45, null);
//		LinkedList singelNode6 = new LinkedList(1, null);
	//	
//		singelNode1.append(singelNode2);
//		singelNode1.append(singelNode3);
//		singelNode1.append(singelNode4);
//		singelNode1.append(singelNode5);
	//	
	//	
//		System.out.println(singelNode1.toString());
	//	
//		singelNode1.remove(5);
//		System.out.println(singelNode1.toString());
	//	
//		singelNode1.remove(45);
//		System.out.println(singelNode1.toString());
//		singelNode1.remove(35);
//		System.out.println(singelNode1.toString());
//		singelNode1.add(4);
//		System.out.println(singelNode1.toString());
		
	}
	
	public static LinkedList singleList(int noOfCells) {
		Random rnd = new Random();
		LinkedList listFill = new LinkedList(0, null);
		
		for(int i = 1; i <= noOfCells; i++) {
			listFill.add(rnd.nextInt(noOfCells));
		}
		
		return listFill;
	}
	
	public static DoubleLinkedList doubleList(int noOfCells) {
		Random rnd = new Random();
		DoubleLinkedList listFill = new DoubleLinkedList(0, null, null);
		
		for(int i = 1; i <= noOfCells; i++) {
			listFill.add(rnd.nextInt(noOfCells));
		}
		
		return listFill;
	}
	


}

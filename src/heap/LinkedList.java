package heap;

public class LinkedList{
	  public void add (int value){
		  if (first == null){
			  first = new Node(value, null);
			  last = first;
		  }
		  else{
			  Node current = first;
			  while (current.next != null)
			  {
				  current = current.next;
			  }
			  current.next = new Node(value, null);
			  last = current.next;
		  }
	  }
	}

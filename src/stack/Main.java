package stack;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item[] items = new Item[100]; //Use for dynamic stack
		//Item[] items = new Item[3]; //Use for static stack
		ItemType typeValue = ItemType.VALUE;
		ItemType typeAdd = ItemType.ADD;
		ItemType typeWMUL = ItemType.WMUL;
		ItemType typeMOD = ItemType.MOD;
		ItemType typeSUB = ItemType.SUB;
		
		/*
		 * Use for static stack
		 */
		items[0] = new Item(typeValue, 5);
		items[1] = new Item(typeValue, 3);
		items[2] = new Item(typeAdd, 0);
		
		/*
		 * Use for dynamic stack
		 */
		
	    items[0] = new Item(typeValue, 10);
	    
	    items[1] = new Item(typeValue, 0);//
	    
	    items[2] = new Item(typeValue, 2);
	    items[3] = new Item(typeWMUL, 0);
	    
	    items[4] = new Item(typeValue, 0);//
	    
	    items[5] = new Item(typeAdd, 0);
	    
	    items[6] = new Item(typeValue, 0);//
	    
	    items[7] = new Item(typeValue, 2);
	    items[8] = new Item(typeWMUL, 0);
	    items[9] = new Item(typeAdd, 0);
	    
	    items[10] = new Item(typeValue, 7);//
	    
	    items[11] = new Item(typeAdd, 0);
	    
	    items[12] = new Item(typeValue, 2);//
	    
	    items[13] = new Item(typeValue, 2);
	    items[14] = new Item(typeWMUL, 0);
	    items[15] = new Item(typeAdd, 0);
	    
	    items[16] = new Item(typeValue, 2);//
	    
	    items[17] = new Item(typeAdd, 0);
	    
	    items[18] = new Item(typeValue, 0);//
	    
	    items[19] = new Item(typeValue, 2);
	    items[20] = new Item(typeWMUL, 0);
	    items[21] = new Item(typeAdd, 0);
	    
	    items[22] = new Item(typeValue, 7);//
	    
	    items[23] = new Item(typeAdd, 0);
	    
	    items[24] = new Item(typeValue, 6);//
	    
	    items[25] = new Item(typeValue, 2);
	    items[26] = new Item(typeWMUL, 0);
	    items[27] = new Item(typeAdd, 0);
	    items[28] = new Item(typeMOD, 0);
	    items[29] = new Item(typeSUB, 0);
	    items[30] = new Item(typeMOD, 0);
		
	
		//Calculator calc = new Calculator(items); //Use for static stack
		DynamicCalculator calc = new DynamicCalculator(items); //Use for dynamic stack
		int result = calc.run();
		System.out.println(result);
	}

}

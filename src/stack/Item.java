package stack;

public class Item {
	private ItemType type;
	private int value = 0;
	//add code
	
	public ItemType getType() {
		return this.type;
	}
	
	public int getValue() {
		return this.value;
	}
	
	
	public Item(ItemType type, int value) {
		//ItemType[] types = ItemType.values();
		this.type = type;
		this.value = value;
	} 
	
	/*
	public int value() {
		return value;
	} */
}

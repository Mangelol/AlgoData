package hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class NoBucketsHashTable {
	Node[] data;
	int max;
	int size = 39293;
	
	public class Node {
		Integer code;
		String name;
		Integer pop;
		Node next;
		
		public Node(Integer code, String name, Integer pop) {
			this.code = code;
			this.name = name;
			this.pop = pop;
		}
	}
	
	public NoBucketsHashTable(String file) {
		data = new Node[size];
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while((line = br.readLine()) != null) {
				String[] row = line.split(",");
				Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
				Node post = new Node(code, row[1], Integer.valueOf(row[2]));
				insert(post);
			}
			max = i - 1;
		} catch(Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}
	
	public void insert(Node insertNode) {
		int index = hashCode(insertNode.code);
		if(data[index] == null) {
			data[index] = insertNode;
			return;
		}
	}
	
	public String linearLookUp(Integer key) {
		int index = hashCode(key);
		if(data[index] == null) {
			return "No key has this value";
		}
		if(data[index].code.equals(key)) {
			return data[index].name;
		}
		else {
			while(++index < size) {
				if(data[index] == null) {
					return "no key has this value";
				}
				if(data[index].code.equals(key)) {
					return data[index].name;
				}
			}
			return "No key has this value";
		}
	}
	
	public int hashCode(Integer key) {
		return key & size;
	}
}

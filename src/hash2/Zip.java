package hash2;

import java.io.*;
public class Zip {
	Node[] data;
	int max;

	public class Node {
		String code;
		String name;
		Integer pop;
		
		public Node(String code, String name, Integer pop) {
			this.code = code;
			this.name = name;
			this.pop = pop;
		}
	}

	public Zip(String file) {
		data = new Node[10000];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
			}
			max = i - 1;
		} catch (Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}
	
	public boolean lookUp(String entry) {
		for (int i = 0; i<data.length; i++) {
			if(data[i] == null)
				break;
			if (data[i].code.equals(entry))
				return true;
		}
		return false;
	}
	
	public boolean binarySearch(String entry) {
		int first = 0;
		int last = max;
		
		while(true) {
			int middle = (last + first)/2;
			
			if(data[middle] == null)
				return false;
			
			if(data[middle].code.equals(entry))
				return true;
			if (data[middle].code.compareTo(entry) < 0 && middle < last) {
				first = middle + 1;
				continue;
			}
			
			if (data[middle].code.compareTo(entry) > 0 && middle > first) {
				last = middle - 1;
				continue;
			}
			
			break;		
		}
		return false;
	}
	
	
}

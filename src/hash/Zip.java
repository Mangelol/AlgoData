package hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {

	Node[] data;
	int max;
	
	public class Node {
		public String code;
		public String name;
		public Integer pop;
		
		public Node(String code, String name, Integer pop) {
			this.code = code;
			this.name = name;
			this.pop = pop;
		}
	}
	
	public Zip(String file) {
		data = new Node[10000];
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while((line = br.readLine()) != null) {
				String[] row = line.split(",");
				data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
			}
			max = i - 1;
		} catch(Exception e) {
			System.out.println(" file " + file + " not found or corrupt");
		}
	}
	
	public boolean linearLookUp(String entry) {
		for(int i = 0; i < data.length; i++) {
			if(data[i] == null) {
				break;
			}
			if(data[i].code.equals(entry)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean binarySearch(String entry) {
		int first = 0;
		int last = max;
		
		while(true) {
			int mid = (first + last) / 2;
			if(data[mid] == null) {
				return false;
			}
			if(data[mid].code.equals(entry)) {
				return true;
			}
			if(data[mid].code.compareTo(entry) < 0 && mid < last) {
				first = mid + 1;
				continue;
			}
			if(data[mid].code.compareTo(entry) > 0 && mid > first) {
				last = mid - 1;
				continue;
			}
		}
	}
}
	


package hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class IndexKeyZip {
	Node[] data;
	int min;
	int max;
	
	public class Node{
		Integer code;
		String name;
		Integer pop;
		
		public Node(Integer code, String name, Integer pop) {
			this.code = code;
			this.name = name;
			this.pop = pop;
		}
	}
	
	public IndexKeyZip(String file) {
		data = new Node[10000];
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			Integer code = 0;
			while((line = br.readLine()) != null) {
				if(code.equals(0)) {
					String[] row = line.split(",");
					code = Integer.valueOf(row[0].replaceAll("\\s", ""));
					min = code;
					data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
					code++;
				}
				else {
					String[] row = line.split(",");
					code = Integer.valueOf(row[0].replaceAll("\\s", ""));
					data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
					code++;
				}
			}
			max = code - 1;
		} catch(Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}
	
	public boolean linearLookUp(Integer entry) {
		if(data[entry] == null) {
			return false;
		}
		if(data[entry].code.equals(entry)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	public boolean binarySearch(Integer entry) {
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
			if(Integer.compare(data[mid].code, entry) < 0 && mid < last) {
				first = mid + 1;
				continue;
			}
			if(Integer.compare(data[mid].code, entry) > 0 && mid > first) {
				last = mid - 1;
				continue;
			}
			break;
		}
		return false;
	} */
	
}

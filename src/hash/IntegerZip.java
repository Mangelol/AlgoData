package hash;

import java.io.*;
public class IntegerZip {
	
	Node[] data;
	Integer[] keys;
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
	
	public IntegerZip(String file) {
		keys = new Integer[10000];
		data = new Node[10000];
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			int j = 0;
			while((line = br.readLine()) != null) {
				String[] row = line.split(",");
				Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
				keys[j++] = code;
				data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
			}
			max = i - 1;
		} catch(Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}
	
	public boolean linearLookUp(Integer entry) {
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
	}
	
	public void collisions(int mod) {
		int[] data = new int[mod];
		int[] cols = new int[10];
		for(int i = 0; i < max; i++) {
			Integer index = keys[i] % mod;
			cols[data[index]]++;
			data[index]++;
		}
		System.out.print(mod);
		for(int i = 0; i < 10; i++) {
			System.out.print("\t" + cols[i]);
		}
		System.out.println();
	}
}

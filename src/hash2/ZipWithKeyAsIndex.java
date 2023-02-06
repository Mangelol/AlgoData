package hash2;

import java.io.*;
public class ZipWithKeyAsIndex {
	Node[] data;
	int min;
	int max;

	public class Node {
		Integer code;
		String name;
		Integer pop;
		
		public Node(Integer code, String name, Integer pop) {
			this.code = code;
			this.name = name;
			this.pop = pop;
		}
	}

	public ZipWithKeyAsIndex(String file) {
		data = new Node[100000];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			Integer code = 0;			
			while ((line = br.readLine()) != null) {
				if(code.equals(0)) {
					String[] row = line.split(",");
					code = Integer.valueOf(row[0].replaceAll("\\s",""));
					min = code;
					data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
					code++;
				}
				else {
				String[] row = line.split(",");
				code = Integer.valueOf(row[0].replaceAll("\\s",""));
				data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
				code++;
				}
			}
			
			max = code - 1;
		} catch (Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}
	
	public boolean lookUp(Integer entry) {
		if (data[entry] == null) {
			return false;
		}
		if (data[entry].code.equals(entry)) {
			return true;
		}
			
		else {
			return false;
		}
	}
	
//	public boolean binarySearch(Integer entry) {
//		int first = min;
//		int last = max;
//		int middle = 0;
//		while(true) {
//			middle = (last + first)/2;
//			
//			if(data[middle] == null) {
//				
//			}
//			
//			if(data[middle].code.equals(entry)) {
//				return true;
//			}
//			
//			
//			if (Integer.compare(data[middle].code, entry) < 0 && middle < last) {
//				first = middle + 1;
//				continue;
//			}
//			
//			if (Integer.compare(data[middle].code, entry) > 0 && middle > first) {
//				last = middle - 1;
//				continue;
//			}
//			
//			System.out.println(data[middle].code + " " + middle + " " + first + " " + last);
//			break;		
//		}
//		return false;
//	}
	
	
}

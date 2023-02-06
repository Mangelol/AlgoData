package hash2;

import java.io.*;
public class Main {
	public static void main(String[] arg) {
		int size = 39293;
		HashTableNoBucket hash = new HashTableNoBucket("postnummer.csv");
		int sthlm = 11115%size;
		int solna = 17165%size;
		int boden = 96128%size;
		System.out.println(hash.data[sthlm].code + " " + hash.data[sthlm].name + hash.data[sthlm].pop );
		System.out.println(hash.data[solna].code + " " + hash.data[solna].name + hash.data[solna].pop );
		System.out.println(hash.data[boden].code + " " + hash.data[boden].name + hash.data[boden].pop );
		
		System.out.println(hash.lookUp(11115));
		System.out.println(hash.lookUp(17165));
		System.out.println(hash.lookUp(96128));		
		System.out.println(hash.lookUp(172637)); //Denna är inte från filen	
		System.out.println(" ");
		
		ZipWithInteger zip = new ZipWithInteger("postnummer.csv");
		zip.collisions(12345);
		
//		ZipWithInteger testZ4 = new ZipWithInteger("postnummer.csv");
//		testZ4.collisions(10000);
//		 39293
		
//		HashTable hash1 = new HashTable("postnummer.csv");
//
//		System.out.println(hash1.data[sthlm].code + " " + hash1.data[sthlm].name + hash1.data[sthlm].pop );
//		System.out.println(hash1.data[solna].code + " " + hash1.data[solna].name + hash1.data[solna].pop );
//		System.out.println(hash1.data[boden].code + " " + hash1.data[boden].name + hash1.data[boden].pop );
//		
//		System.out.println(hash.lookUp(11115));
//		System.out.println(hash.lookUp(17165));
//		System.out.println(hash.lookUp(96128));		
//		System.out.println(hash.lookUp(172637)); //Denna är inte från filen	
		
//		 Om size är 10000, alla noder som delar index med solna, (som slutar på 7165)
//		System.out.println(" ");
//		HashTable.Node current = hash1.data[solna];
//		while(current != null) {
//			System.out.println(current.code + " " + current.name + current.pop );
//			current = current.next;
//			
//		}
		
		
		
		
//		Zip testZ = new Zip("postnummer.csv");
//		System.out.println(testZ.data[0].code + " " +  testZ.data[0].name + testZ.data[0].pop);
//		System.out.println(testZ.data[1].code + " " +  testZ.data[1].name + testZ.data[1].pop);
//		System.out.println(testZ.data[2].code + " " +  testZ.data[2].name + testZ.data[2].pop);
//		System.out.println(testZ.data[3].code + " " +  testZ.data[3].name + testZ.data[3].pop);
//		
//		System.out.println(testZ.lookUp("111 15"));
//		System.out.println(testZ.lookUp("113 31"));
//		System.out.println(testZ.lookUp("115 36"));
//		System.out.println(testZ.lookUp("117 57"));
//		System.out.println(testZ.lookUp("994 99"));
//		
//		System.out.println(testZ.binarySearch("111 15"));
//		System.out.println(testZ.binarySearch("113 31"));
//		System.out.println(testZ.binarySearch("115 36"));
//		System.out.println(testZ.binarySearch("117 57"));
//		System.out.println(testZ.binarySearch("994 99"));
//		
//		ZipWithInteger testZ2 = new ZipWithInteger("postnummer.csv");
//		System.out.println(testZ2.data[0].code + " " +  testZ2.data[0].name + testZ2.data[0].pop);
//		System.out.println(testZ2.data[1].code + " " +  testZ2.data[1].name + testZ2.data[1].pop);
//		System.out.println(testZ2.data[2].code + " " +  testZ2.data[2].name + testZ2.data[2].pop);
//		System.out.println(testZ2.data[3].code + " " +  testZ2.data[3].name + testZ2.data[3].pop);
//		
//		System.out.println(testZ2.lookUp(11115));
//		System.out.println(testZ2.lookUp(11331));
//		System.out.println(testZ2.lookUp(11536));
//		System.out.println(testZ2.lookUp(11757));
//		System.out.println(testZ2.lookUp(99499));
//		
//		System.out.println(testZ2.binarySearch(11115));
//		System.out.println(testZ2.binarySearch(11331));
//		System.out.println(testZ2.binarySearch(11536));
//		System.out.println(testZ2.binarySearch(11757));
//		System.out.println(testZ2.binarySearch(99499));
		
//		ZipWithKeyAsIndex testZ3 = new ZipWithKeyAsIndex("postnummer.csv");
//		System.out.println(testZ3.data[11115].code + " " +  testZ3.data[11115].name + testZ3.data[11115].pop);
//		System.out.println(testZ3.data[11331].code + " " +  testZ3.data[11331].name + testZ3.data[11331].pop);
//		System.out.println(testZ3.data[11536].code + " " +  testZ3.data[11536].name + testZ3.data[11536].pop);
//		
//		System.out.println(testZ3.lookUp(11115));
//		System.out.println(testZ3.lookUp(11331));
//		System.out.println(testZ3.lookUp(11536));
//		System.out.println(testZ3.lookUp(11757));
//		System.out.println(testZ3.lookUp(99499));
		
//		System.out.println(testZ3.binarySearch(11115));
//		System.out.println(testZ3.binarySearch(11331));
//		System.out.println(testZ3.binarySearch(11536));
//		System.out.println(testZ3.binarySearch(11757));
//		System.out.println(testZ3.binarySearch(99499));
		




		
		
		
//		Integer s = 23;
//		Integer s2 = 20;
//		
//		System.out.println(Integer.compare(s, s2));

//		String s = "23";
//		String s2 = "20";
//		
//		System.out.println(s.compareTo(s2));
		
//	Integer a = 123;
//	Integer b = 123;
//
//	System.out.println(" a = " + a + " and b = " + b + " and a == b returns " + (a == b));
//
//	Integer x = 12345;
//	Integer y = 12345;
//
//	System.out.println(" x = " + x + " and y = " + y + " but x == y returns " + (x == y));
//
//	System.out.println(" so use x.equals(y) that returns " + (x.equals(y)) + " if comparing Integers");		
    }

}

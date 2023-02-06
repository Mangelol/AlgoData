package t9;

import java.util.*;
import java.io.*;
import java.nio.*;
public class Trie {
	
	Node root;
	
	public Trie() {
		try {
		BufferedReader read = new BufferedReader(new FileReader("kelly.txt"));
	//	ArrayList<String> list = new ArrayList<>();
		String line = read.readLine();
		while(line != null) {
			add(line);
			line = read.readLine();
		}
		} catch(Exception e) {
			System.out.println("fkn hell");
		}
	}
	
	public String[] realSearch(String key) {
		if(key != null && key.length() > 0) {
			return root.realSearch(key, "").split(" ");
		}
		else {
			return new String[0];
		}
	}
	
	public class Node {
		public Node[] arrayChar;
		public boolean word;
		
		public Node() {
			arrayChar = new Node[27];
			word = false;
		}
		
		private String realSearch(String key, String word) {
			if(key.equals("")) {
				if(this.word) {
					return word;
				}
				else {
					return "";
				}
			}
			int firstIndex = getIndex(key.charAt(0) - '0' ) * 3;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 3; i++) {
				String possibleWord = "";
						if(arrayChar[firstIndex + i] != null) {
							possibleWord = arrayChar[firstIndex + i].realSearch(key.substring(1), word + findCharacter(firstIndex + i));
						}
				sb.append(possibleWord);
				if(!possibleWord.endsWith(" ")) {
					sb.append(' ');
				}
			}
			return sb.toString();
		}
		
	}
	
	public static int findCharacterCode(char letter) {
		int code = (int)letter - 97;
		
		if(code > 15) { //to remove q because q is 16
			code--;
		}
		if(code > 20) { //to remove w because w is 21
			code--;
		}
		if(code == 130) {
			return 24; //å
		}
		if(code == 129) {
			return 25; //ä
		}
		if(code == 147) {
			return 26; //ö
		}
		return code;
	}
	
	public static char findCharacter(int code) {
		if(code > 26) {
			System.out.println("Something bad happened");
			return ' ';
		}
		if(code == 24) {
			return 'å';
		}
		if(code == 25) {
			return 'ä';
		}
		if(code == 26) {
			return 'ö';
		}
		if(code > 15) {
			code++;
		}
		if(code > 20) {
			code++;
		}
		
		return (char)(code + 97);
	}
	
	public static int getIndex(int key) {	
		return key - 1; //changes 1-9 to 0-8
	}
	
	public static int getKey(char letter) {
		return (findCharacterCode(letter) / 3) + 1;
	}
	
	public void add(String word) {
		Node current = root;
		for(int i = 0; i < word.length(); i++) {
			if(current.arrayChar[findCharacterCode(word.charAt(i))] == null ) {
				current.arrayChar[findCharacterCode(word.charAt(i))] = new Node();
			}
			current = current.arrayChar[findCharacterCode(word.charAt(i))];
		}
		current.word = true;
	}
}

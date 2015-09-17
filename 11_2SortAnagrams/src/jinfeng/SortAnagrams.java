/*cc150 11.2
 * Write a method to sort an array of strings so that all the anagrams are next to each other
 * */

package jinfeng;

import java.util.Arrays;
import java.util.Comparator;

public class SortAnagrams {

	public static void main(String[] args) {
		String[] str = {"california","northcarolina","newyork","florida", "northcarolina"};
		
		// initialize string arrays
		
		
		// implement sorting algorithm on array str
		Arrays.sort(str, new AnagramComparator());
		
		
		for (int i = 0; i < str.length; i++){
			System.out.println(str[i]);
		}
		

	}
	
	

}

class AnagramComparator implements Comparator<String> {
	public String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new  String(content);
	}
	
	public int compare(String s1, String s2){
		return sortChars(s1).compareTo(sortChars(s2));
	}
}

/*cc150 11.5
 * Given a sorted array of strings which is interspersed with empty strings, write a 
 * method to find the location of a given string.
 * EXAMPLE
 * Input: find "ball" in{"at","","","","ball", "", "", "car",
 *                       "","","dad","",""}
 * */

package jinfeng;

public class FindString {

	public static void main(String[] args) {
		String[] str = {"at","","","","ball", "", "", "car",
				"","","dad","",""};

		String target = "car";
		
		int low = 0;
		int high = str.length - 1;
		int result = search(str, target, low, high);
		System.out.println("The index of string: " + target + " at the string array is:  " + result);
	}
	public static int search(String[] a, String target, int low, int high){
		int middle = (low + high)/2;
		if (a[low].equals(target)) 
			return low;
		if (a[high].equals( target))
			return high;
		if (a[middle].equals(target))
			return middle;
		if (!a[middle].equals("")){// do nothing
			
		}
		else {//a[middle] = "", so get new middle
			int i = 1;
			while(middle - i >= low || middle + i <= high) {
				
				if ((middle - i >= low)&&(!a[middle - i].equals("")) ){
					middle = middle - i;
					break;
				}
					
				if ((middle + i <= high)&&(!a[middle + i].equals(""))){
					middle = middle + i;
					break;
				}
			i++;
		}
		}
		
		// compare target with middle
		if (target.compareTo( a[middle]) > 0)
			return search(a, target, middle + 1, high);
		else
			return search(a, target, low, middle);
		
	}

}

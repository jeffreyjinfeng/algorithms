import java.util.HashMap;

//1.3 Given two strings, write a method to decide if one is a permutation of the other.
public class PermutationString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str1 = "helo";
        String str2 = "lleho";
        System.out.println("String1: " + str1 +" and String2: " + str2 +
        		"are permutation to each other? " + permutation(str1, str2));
        
	}

	public static boolean permutation(String str1, String str2){
		char[] chararray1 = str1.toCharArray();
        char[] chararray2 = str2.toCharArray();
        HashMap map = new HashMap();
        int value;
        if (str1.length() != str2.length())
        	return false;
        //calculate string1 then add the counts of elements into the hashmap
        for (char e: chararray1){
        	if (map.containsKey(e)){
        		value = (int)map.get(e);
        		map.put(e, value+1);
        	}else{
        		map.put(e, 1);
        	}
        }
        
        //reduce hashmap based on the elements in string2
        for (char f: chararray2){
        	if (!map.containsKey(f))
        		return false;
        	value = (int)map.get(f);
        	value = value - 1;
        	if (value < 0) return false;
        	map.put(f, value);
        }
        return true;
	}
}

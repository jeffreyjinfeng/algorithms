import java.util.ArrayList;
import java.util.List;

/*
 * leetocde: Substring with Concatenation of All Words
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once 
 * and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 * */
public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String S, String[] L) {
        int lengthL = L.length;
        int subLength = L[0].length();
        int lengthS = S.length();
        List<Integer> ls = new ArrayList<Integer>();
        
        List<String> al = new ArrayList<String>();
        for (String s: L) {
            al.add(s);
        }
        
        int length = lengthS - lengthL * subLength + 1;
        for (int i = 0; i < length; i++) {
            if (!al.contains(S.substring(i, i + subLength))) {
                continue;
            } else {
                List<String> tempAl = new ArrayList<String>(al);
                int current = i;
                for (int m = 0; m < lengthL; m++) {
                    if (tempAl.contains(S.substring(current, current + subLength))) {
                        tempAl.remove(S.substring(current, current + subLength));
                        current = current + subLength;
                    } else {
                        break;
                    }
                }
                
                if (tempAl.size() == 0) {
                    ls.add(i);
                }

            }
        }
        return ls;
    }

}

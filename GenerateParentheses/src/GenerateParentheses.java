import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * */
public class GenerateParentheses {



	    public List<String> generateParenthesis(int n) {
	        HashSet<String> hs = new HashSet<String>();
	        for (int i = 0; i < n; i++) {
	            hs = addPair(hs);
	        }
	        
	        List<String> list = new ArrayList<String>(hs);
	        return list;
	    
	    }
	    
	    public static HashSet<String> addPair(HashSet<String> ls) {
	        if (ls.isEmpty()) {
	            ls.add("()");
	            return ls;
	        } else {
	            HashSet<String> result = new HashSet<String>();
	            for (String s: ls) {
	                int length = s.length();
	                for (int i = 0; i <= length; i++) {
	                    for (int j = i; j <= length; j++) {
	                        if (i == length) {
	                            result.add(s.concat("()"));
	                        } else if (i == j) {
	                            if (i == 0) {
	                                result.add("()".concat(s));
	                            }else {
	                                result.add(s.substring(0, i) + "()" + s.substring(i));
	                            }
	                        } else {
	                            if (i == 0) {
	                                if (j == length) {
	                                    result.add("(" + s + ")");
	                                } else {
	                                    result.add("(" + s.substring(0, j) + ")" + s.substring(j));
	                                }
	                            } else {
	                                if (j == length) {
	                                    result.add(s.substring(0, i) + "(" + s.substring(i) + ")");
	                                } else {
	                                    result.add(s.substring(0, i) + "(" + s.substring(i, j) + ")" + s.substring(j));
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	            
	        return result;    
	        }
	        
	    }

}


public class DistinctSubsequences {

	public static void main(String[] args) {
		String s = "abcde";
		String t = "ace";
		System.out.println(numDistinct(s, t));

	}

	
	
	
    public static int count = 0;
    public static int numDistinct(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }
        process(s, t);
        return count;
    }
    
    public static void process(String s, String t) {
        char x = t.charAt(0);
        int length = s.length();
        int lengthT = t.length();
        for (int i = 0; i < length; i++) {
            if (x == s.charAt(i)) {
              if (lengthT == 1) {
                  count++;
              } else {
                  if (i < length - 1) {
                      process(s.substring(i + 1), t.substring(1));
                  }
              } 
            } 
        }
        
    }	
}

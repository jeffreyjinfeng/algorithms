/*
 * leetcode
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * */
public class CountandSay {
    public String countAndSay(int n) {
        String str = "1";
        int time = n - 1;
        for (int i = 0; i < time; i++) {
            str = next(str);
        }
        return str;
    }
    
    public String next(String str) {
        char tempChar = str.charAt(0);
        int count = 0;
        int length = str.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != tempChar) {
                result = result + count + tempChar;
                tempChar = str.charAt(i);
                count = 1;
            } else {// == tempChar
                count++;
            }
        }
        result = result + count + tempChar;
        return result;
    }
}

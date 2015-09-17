/*
 * leetcode
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        int length = haystack.length();
        
        if (needleLen > length) return -1;
        int lastCheck = length - needleLen;
        
        for (int i = 0; i <= lastCheck; i++) {
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}

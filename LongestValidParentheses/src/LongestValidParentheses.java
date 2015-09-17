import java.util.Stack;

/*
 * leetcode: Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 * status: exceeds time limit
 * */
public class LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("((((()()(((((())()((()(((()))(()(()))(()(()())))())(()((((()((()(((((()()))((()(()((())()))))(()(("));

	}
    public static int longestValidParentheses(String s) {
        int largest = 0;
        int count = 0;
        int initIndex = 0;
        int currentIndex = 0;
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        while (initIndex < length) {
        	
            if (initIndex == length - 1) {
                initIndex++;
                continue;
            }
            if (s.charAt(initIndex) == ')') {
                initIndex++;
                continue;
            } else {
                count = 0;
                currentIndex = initIndex;
                stack = new Stack<Character>();
                while (currentIndex < length) {
                    if (s.charAt(currentIndex) == '(') {
                        stack.push('(');
                        count++;
                        currentIndex++;


                    }
                    else if (s.charAt(currentIndex) == ')') {
                        if (stack.isEmpty()) {
                            initIndex = currentIndex + 1;
                            break;
                        } else {
                            stack.pop();
                            count++;
                            if (stack.isEmpty()) {
                                if (count > largest) 
                                    largest = count;
                                initIndex = currentIndex;//test
                            }
                            currentIndex++;
                            
                            continue;
                        }
                    }
                }
                if (count == stack.size()) {
                	initIndex = currentIndex;
                	continue;
                }
                if (!stack.isEmpty()) {
                	initIndex++;
                } 
            }    
        }
        return largest;
    }
}

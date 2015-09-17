import java.util.Stack;

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * */
public class ValidParentheses {
    public boolean isValid(String s) {
        int current = 0;
        Stack<Character> st = new Stack<Character>();
        int length = s.length();
        while (current < length) {
            if (s.charAt(current) == '(' || s.charAt(current) == '{' || s.charAt(current) == '[') {
                st.push(s.charAt(current));
                current++;
            } else if (st.isEmpty()) {
                return false;
            } else if (s.charAt(current) == ')'){
                if (st.pop() != '(')
                    return false;
                else 
                    current++;
                
            } else if (s.charAt(current) == '}'){
                if (st.pop() != '{') 
                    return false;
                else
                    current++;
            } else if (s.charAt(current) == ']'){
                if (st.pop() != '[')
                    return false;
                else 
                    current++;
            }
        }
        if (st.isEmpty())
            return true;
        else 
            return false;
    }
}

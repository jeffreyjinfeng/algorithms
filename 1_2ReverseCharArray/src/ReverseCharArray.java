//Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.

public class ReverseCharArray {

	public static void main(String[] args) {
		String test = "Hello World!";
        System.out.println("The reversed String of: " + test + " is: " + reverse(test.toCharArray()));
	}

	public static String reverse(char[] str){
		StringBuffer sb = new StringBuffer();
		int len = str.length;
		int index = len - 1;
		for (int i = 0; i < len; i++){
			sb.append(str[index]);
			index--;
		}
		return sb.toString();
		
		}
	
}

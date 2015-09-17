/*cc150 1.4 Write a method to replace all spaces in a string with '%20'. You may assume that the stringhas sufficient space at the end of the string to hold the additional characters, 
 * and that you are given the "true" length of the string(use character array you performed in Java) */
public class ReplaceString {

	public static void main(String[] args) {
		char[] str ="Hello World computer          ".toCharArray() ;
		System.out.print(replace(str,str.length));

	}

	public static char[] replace(char[] ch, int _size){
		int size = _size;
		char[] chararray = new char[size];
		int i = 0; //index of chararray
		int j = 0; // index of ch (original array)
		for (; j < size; j++){
			if (j == size - 1) {
				chararray[i] = ch[j]; 
				i++;
				
			}
			
			else if (ch[j]==' '&&ch[j+1]!=' '){
				    chararray[i] = '%';
			        chararray[i+1] = '2';
				    chararray[i+2] ='0';
				    i = i + 3;
			}
			else if (ch[j]==' '&&ch[j+1]==' '){
				// do nothing
			}
			else{
				chararray[i] = ch[j]; 
				i++;
			}
		}
		return chararray;
	}
}

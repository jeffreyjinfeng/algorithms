import java.util.Scanner;


public class ZeroOne {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        long inputValue = sc.nextInt();
        long N = inputValue + 1;
        
        for (int i = 1; i <= N; i++){
        	String temp = "";
        	for (int j = 1; j <=N; j++){
        		temp = temp.concat("1");
        	}
        	temp = temp.concat("0");
          long tempLong = Long.parseLong(temp);
          if (tempLong%inputValue == 0){
        	  System.out.println(temp);
        	  break;
          }
        }
        
	}

}

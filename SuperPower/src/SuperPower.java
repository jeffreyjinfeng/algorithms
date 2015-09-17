
public class SuperPower {

	public static void main(String[] args) {
		System.out.println(superPower(1001));

	}

	
	static int superPower(int z) {
       int squareRoot = (int) Math.sqrt(z);
       double smallEnough = 0.0000001;
       double tempDouble;
       int tempInt;
       if (squareRoot < 2) return 0;
       
       for (int i = 2; i <= squareRoot; i++){
    	   tempDouble = Math.log(z)/Math.log(i);
    	   tempInt = (int)tempDouble;
    	   if (tempDouble - tempInt < smallEnough && tempDouble >= tempInt){
    		   return 1;
    	   }
       }
       return 0;
    }
}

import java.util.ArrayList;


public class Test {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = (ArrayList<String>)list1.clone();
		
		if (list1 == list2) System.out.println("same");
		else System.out.println("different");

	}

}

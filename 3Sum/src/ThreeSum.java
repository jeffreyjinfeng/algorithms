import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ThreeSum {

	public static void main(String[] args) {
		int[] num = {0,0,0 };
		
		threeSum(num);

	}

    public static List<List<Integer>> threeSum(int[] num) {
        int length = num.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (length < 3) return list;
        //sorting num
        Arrays.sort(num);
        
     
        int lowerBound = 1;
        int upperBound = length - 2;
        int mid = lowerBound;
        int left;
        int right;
        int target;
        
        
        while (mid <= upperBound) {
    		if (mid + 1 < length && num[mid + 1] == num[mid]) {
    			mid++;
    			continue;
    		}
        	target = 0 - num[mid];
        	left = mid - 1;
        	right = mid + 1;
        	
        	while (left >= 0 && right < length) {

        		
        		if (num[left] + num[right] == target) {
        			List<Integer> al = new ArrayList<Integer>();
        			al.add(num[left]);
        			al.add(num[mid]);
        			al.add(num[right]);
        			
        			list.add(al);
        			
        			left--;
        			while (left - 1 >= 0 && num[left - 1] == num[left]) {
        				left--;
        			}
        			right++;
        			
        			while (right + 1 < length && num[right + 1] == num[right]) {
        				right++;
        			}
        			continue;
        		}
        		
        		if (num[left] + num[right] > target) {
        			left--;
        			while (left - 1 >= 0 && num[left - 1] == num[left]) {
        				left--;
        			}
        		} else { // num[left] + num[right] < target
        			right++;
        			while (right + 1 < length && num[right + 1] == num[right]) {
        				right++;
        			}
        		}
        	}
        	mid++;
        	
        }
        return list;
    }
}

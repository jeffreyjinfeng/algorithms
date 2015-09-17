import java.util.HashSet;


public class HouseRobber {

	public static void main(String[] args) {
		int[] nums =  {1,2,3,4,5};
		System.out.println(rob(nums));
	}

	
    public static int rob(int[] nums) {
        HashSet<Integer> visited = new HashSet<Integer>();
        return action(nums, visited, 0);
    }
    
    public static int action(int[] nums, HashSet<Integer> visited, int sum) {
        
        if (visited.size() == nums.length) return sum;
        int maxValue = 0;
        int indexOfMax = 0;
        

        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(i)) {
                if (nums[i] >= maxValue) {
                    maxValue = nums[i];
                    indexOfMax = i;
                }
            }
        }
        

        visited.add(indexOfMax);
        HashSet<Integer> visited2 = (HashSet<Integer>)visited.clone();
        visited.add(indexOfMax);
        if (indexOfMax + 1 < nums.length) visited2.add(indexOfMax + 1);
        if (indexOfMax - 1 >= 0) visited2.add(indexOfMax - 1);
        

        return getMax(action(nums, visited, sum), action(nums, visited2, sum + maxValue));
        
    }
    
    public static int getMax(int a, int b) {
        if (a >= b) return a;
        else return b;
    }
}

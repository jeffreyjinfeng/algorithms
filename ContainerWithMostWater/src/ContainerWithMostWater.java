
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = {1,2,4,3};
		System.out.println(maxArea(height));
	}

    public static int maxArea(int[] height) {
    	int length = height.length;
    	if (length == 1) return 0;
    	
    	int area = 0;
    	int biggestArea = 0;
    	int start = 0;
    	int end = length - 1;
    
    	while (start < end) {
    		
    		if (height[start] >= height[end]) {
    			area = (end - start) * height[end];
    			int endOld = end;
    			while (end >= 0 && height[end] <= height[endOld]) {
    				end--;
    			}
    		} else {
    			area = (end - start) * height[start];
    			int startOld = start;
    			while (start < length && height[start] <= height[startOld]) {
    				start++;
    			}
    		}
    		
    		if (area > biggestArea) {
    			biggestArea = area;
    		}
    		
    		
    	}
    	return biggestArea;
    }
}

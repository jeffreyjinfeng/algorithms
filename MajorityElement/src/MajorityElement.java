
public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = {7,2,1,2,2,1,1,2,3,2};
		mergeSort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	
	
    
    /*method: sort the array first, then return the number in the middle*/
    public static int majorityElement(int[] nums) {
        int size = nums.length;
        if (size == 1) return nums[0];
        else mergeSort(nums, 0, size - 1);
        
        return nums[size/2];
    }
    
   
    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left)/2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            conquer(nums, left, mid, right);
        }
    }
    
    public static void conquer(int[] nums, int left, int mid, int right) {
        int[] temp = nums.clone();
        int a = left;
        int b = mid + 1;
        int current = left;
        while (a <= mid && b <= right) {
            if (temp[a] <= temp[b]) {
                nums[current] = temp[a];
                current++;
                a++;
            } else {
                nums[current] = temp[b];
                current++;
                b++;
            }
        }
        while (a <= mid) {
            nums[current] = temp[a];
            a++;
            current++;
        }

        
    }
}

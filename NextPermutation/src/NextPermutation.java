/*
 * leetcode: Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * */
public class NextPermutation {

	public static void main(String[] args) {
		int[] arr = {3,4,1,4,3,3};
		nextPermutation(arr);
		for (int i: arr) {
			System.out.print(i + " ");
		}
		
	}

    public static void nextPermutation(int[] num) {
        int length = num.length;
        int targetIndex = 0;
        int temp;
        int tempIndex = -1;
        int I = 0;
        for (int i = length - 1; i > 0; i--) {
            if (num[i - 1] < num[i]) {
                I = i;
                tempIndex = i;
                
                while (i + 1 < length) {
                    if (num[i + 1] > num[I - 1] && num[i + 1] < num[tempIndex]) {
                        tempIndex = i + 1;
                    }
                    i++;
                }

                temp = num[I - 1];
                num[I - 1] = num[tempIndex];
                num[tempIndex] = temp;

                
                targetIndex = I;


                break;
            }
        }

        if (tempIndex == -1) {
            //reverse the array
            for (int i = 0; i < length / 2; i++) {
                temp = num[length - 1 - i];
                num[length - 1 - i] = num[i];
                num[i] = temp;
                
            }
            
        } else {
            int currentTargetIndex = tempIndex;
        	while (currentTargetIndex + 1 < length && num[currentTargetIndex + 1] == num[I - 1]) {
        		temp = num[currentTargetIndex];
        		num[currentTargetIndex] = num[currentTargetIndex + 1];
        		num[currentTargetIndex + 1] = temp;
        		currentTargetIndex++;
        	}
        	for (int i = 0; i < (length - 1 - targetIndex  + 1)/2; i++) {

                temp = num[targetIndex + i];
                num[targetIndex + i] = num[length - 1 - i];
                num[length - 1 - i] = temp;
            }
        }



    }
    

}

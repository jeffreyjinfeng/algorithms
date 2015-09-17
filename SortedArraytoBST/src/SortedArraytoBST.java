
public class SortedArraytoBST {

	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		TreeNode root = sortedArrayToBST(array);
        System.out.println("The value of the root is:" + root.val);
	}

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        int startIndex = 0;
        int endIndex = nums.length - 1;
        process(root, nums, startIndex, endIndex);
        return root;
    }
    
    public static void process(TreeNode root, int[] nums, int startIndex, int endIndex) {
        int index;
        if (startIndex > endIndex) {}
        else {
            if (startIndex == endIndex) {
                add(root, nums[startIndex]);
            } else {
                index = (startIndex + endIndex)/2;
                add(root, nums[index]);
                process(root, nums, startIndex, index - 1);
                process(root, nums, index + 1, endIndex);
            }
            
        }

    }
    
    public static void add(TreeNode root, int value) {
        if (root.val == Integer.MAX_VALUE) {
        	root.val = value;

        }
        else {
            if (value < root.val) {
                if (root.left == null) {
                    root.left = new TreeNode(value);
                    
                } else {
                    add(root.left, value);
                }
                    
            }
            else if (value > root.val) {
                if (root.right == null) {
                    root.right = new TreeNode(value);
                } else {
                    add(root.right, value);
                }
            }
        }
    }
}


class TreeNode {
     int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
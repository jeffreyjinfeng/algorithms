
public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(0);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(2);
		
		a.right = b;
		b.right = c;
		
		System.out.println(sumNumbers(a));

	}

	
    public static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        process(root, root.val);
        return sum;
    }
    
    public static void process(TreeNode node, int value) {
        if (node.left == null && node.right == null) sum = sum + value;
        else {
        if (node.left != null) {
            if (value == 0) process(node.left, node.left.val);
            else process(node.left, value * 10 + node.left.val);
        }
        if (node.right != null) {
            if (value == 0) process(node.right, node.right.val);
            else process(node.right, value * 10 + node.right.val);
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

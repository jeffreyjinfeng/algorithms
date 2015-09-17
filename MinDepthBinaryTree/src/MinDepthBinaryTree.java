import java.util.LinkedList;


public class MinDepthBinaryTree {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		a.right = new TreeNode(2);
		System.out.println("The minimum depth of the given treenode is: " + minDepth(a));

	}

	
    public static int min = Integer.MAX_VALUE;
    public static int minDepth(TreeNode root) {
        
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        
        LinkedList<Integer> depth = new LinkedList<Integer>();
        list.add(root);
        depth.add(1);
        if (root == null) min = 0;
        else {
            while (!list.isEmpty()) {
                process(depth, list);
            }
        }
        
        return min;
    }
    
    public static void process(LinkedList<Integer> depth, LinkedList<TreeNode> list) {
        if (list.isEmpty()) {
            
        } else {
            TreeNode node = list.remove();
            int deep = depth.remove();
            if (node.left == null && node.right == null) {

                if (deep < min) {
                    min = deep;
                }
            }
        
            if (node.left != null) {
                list.add(node.left);
                depth.add(deep + 1);    
            }
    
            if (node.right != null) {
                list.add(node.right);
                depth.add(deep + 1);
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

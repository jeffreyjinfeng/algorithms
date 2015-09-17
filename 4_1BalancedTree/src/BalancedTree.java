/*cc150 4.1
 * Implement a function to check if a binary tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to be a tree 
 * such that the heights of the two subtrees of any node never differ 
 * by more than one.*/
public class BalancedTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node node1 = new Node();
		Node node2 = new Node(); 
		Node node3 = new Node();
		Node node4 = new Node();
		Node node5 = new Node();
		Node node6 = new Node();
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		node5.right = node6;
		
		System.out.println(balance(node1));

	}
	
	public static int height(Node x){
		if (x == null) return 0;
		else
			if (x.left == null && x.right == null) return 1;
			
		
		else if (height(x.left) >= height(x.right)) 
				return height(x.left) + 1;
			else
				return height(x.right) + 1;
		
	}
	
	public static boolean balance(Node root){
		if (root == null) return true;
		if (root.left == null && root.right ==null) return true;
		int l = height(root.left);
		int r = height(root.right);
		if (Math.abs(l-r) > 1)
			return false;
		else {
			return balance(root.left) && balance(root.right);
		}
		
		
		
	}

}

class Node{
	Node left;
	Node right;
}


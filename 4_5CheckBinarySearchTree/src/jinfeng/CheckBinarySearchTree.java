/*cc150 4.5
 * Implement a function to check if a binary tree is a binary search tree
 * */

package jinfeng;

public class CheckBinarySearchTree {

	 public static int flag = 1;
	public static void main(String[] args) {
		Node root = createBinarySearchTree();

		if (root != null) 
			checkBinaryTree(root);
		if (flag == 1) 
			System.out.println("yes");
		else 
			System.out.println("no");
	}

	
	public static void checkBinaryTree(Node root){
	   
	    int middle = root.item;
	    int left;
	    int right;
	    if (root.left != null){
	    	left = root.left.item;
	    }else{
	    	left = (int)Double.NEGATIVE_INFINITY;
	    }
	    if (root.right != null){
	    	right = root.right.item;
	    }else{
	    	right = (int)Double.POSITIVE_INFINITY;
	    }
	    
	   if (left > middle)
		   flag = 0;
	   else if (middle > right)
		   flag = 0;
	    
	  
	    
	    if (root.left != null)  checkBinaryTree(root.left);
	    if (root.right != null)  checkBinaryTree(root.right);
	}
	
	
	public static Node createBinarySearchTree(){
		Node a1 = new Node(100);
		Node a2 = new Node(50);
		Node a3 = new Node(120);
		Node a4 = new Node(25);
		Node a5 = new Node(75);
		Node a6 = new Node(110);
		Node a7 = new Node(140);
		Node a8 = new Node(60);
		Node a9 = new Node(105);
		Node a10 = new Node(155);
		
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a3.left = a6;
		a3.right = a7;
		a5.left = a8;
		a6.left = a9;
		a7.right = a10;
		return a1;
	}
}

class Node{
	public int item;
	public Node left;
	public Node right;
	Node(int i){
		item = i;
	}
}

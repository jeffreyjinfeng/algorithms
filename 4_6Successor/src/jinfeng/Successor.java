/*cc150 4.6
 * Write an algorithm to find the 'next' node (i.e., in-order successor)of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 * 
 * Instruction: http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 * */

package jinfeng;

public class Successor {

	public static void main(String[] args) {
		//create Binary Search Tree
		Node a1 = new Node(20);
		Node a2 = new Node(10);
		Node a3 = new Node(30);
		Node a4 = new Node(5);
		Node a5 = new Node(15);
		Node a6 = new Node(25);
		Node a7 = new Node(40);
		Node a8 = new Node(4);
		
		a1.setLeft(a2);
		a1.setRight(a3);
		a2.setLeft(a4);
		a2.setRight(a5);
		a3.setLeft(a6);
		a3.setRight(a7);
		a4.setLeft(a8);
		
		Node result = nextNode(a1);
		if (result != null)
			System.out.println(result.item);
		else
			System.out.println("No in-order Successor of the given node");
		}

	
	
	/*find the in-order success of a given Node in a binary search tree*/
	public static Node nextNode(Node x){
		if (x.right != null){
			//find the smallest index in the right subtree: left most
			Node right = x.right;
			if (right.left == null) return right;
			else {
				Node temp = right.left;
				while (temp.left != null){
					temp = temp.left;
				}
				return temp.parent;
			}
			
		}
		else {
			Node parent = x.parent;
			if (parent.left == x) return parent;
			else{
				Node parent2 = parent.parent;
				Node temp = parent2;
				while (temp != null) {
					if (temp.left == parent) return temp;
					else {
						parent = temp;
						temp = temp.parent;
					}
				}
				return null;
			}
			
			
		}
	}
}

class Node{
	public int item;
	public Node left;
	public Node right;
	public Node parent;
	
	Node(int i){
		item = i;
		left = null;
		right = null;
		parent = null;
	}
	
	public void setLeft(Node left){
		this.left = left;
		left.parent = this;
	}
	
	public void setRight(Node right){
		this.right = right;
	    right.parent = this;
	}
}
/*cc150 4.9
 * You are given a binary tree in which each node contains a value. Design an algorithm
 * to print all paths which sum to a given value. The path does not need to start or end at the root
 * or a leaf, but it must go in a straight line down.
 * */

package jinfeng;

import java.util.Stack;

public class SumTree {

	public static void main(String[] args) {
		//create a binary tree
		Node a1 = new Node(1);
		Node a2 = new Node(1);
		Node a3 = new Node(1);
		Node a4 = new Node(2);
		Node a5 = new Node(3);
		Node a6 = new Node(4);
		Node a7 = new Node(1);
		Node a8 = new Node(1);
		Node a9 = new Node(1);
		
		a1.setLeft(a2);
		a1.setRight(a3);
		a2.setLeft(a4);
		a2.setRight(a5);
		a3.setLeft(a6);
		a3.setRight(a7);
		a7.setLeft(a8);
		a7.setRight(a9);
		
		printTreeSum(4, a1);

	}

	public static void printTreeSum(int value, Node root){
		Node subRoot = root;
		int sum = 0;
		if (root != null){
			traverse(root, value, sum, subRoot);
		}
		
		// check child node
		if (root.left != null) printTreeSum(value, root.left);
		if (root.right != null) printTreeSum(value, root.right);
	}
	
	public static void traverse(Node x, int value, int temp, Node subRoot){
		if (x == null){}
		else{
			
			temp = temp + x.item;
			if (temp == value){
				Stack<Node> stack = new Stack<Node>();
				while (x != subRoot.parent){
					stack.push(x);
					x = x.parent;
				}
				while (!stack.isEmpty()){
					System.out.print(" " + stack.pop().item);
				}
				System.out.println();
			}else if (temp < value){
				if (x.left != null)
					traverse(x.left, value, temp, subRoot);
				if (x.right != null)
					traverse(x.right, value, temp, subRoot);
			}
		}
		
		
	}
}

class Node{
	public int item;
	Node left;
	Node right;
	Node parent;
	
	Node(int i){
		item = i;
		left = null;
		right = null;
		parent = null;
	}
	
	void setLeft(Node x){
		this.left = x;
		x.parent = this;
	}
	
	void setRight(Node x){
		this.right = x;
		x.parent = this;
	}
}
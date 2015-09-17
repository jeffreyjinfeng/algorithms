/*cc150 4.8
 * You have two very large binary trees: T1, with millions of nodes, and T2, 
 * with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that  the subtree of
 * n is identical to T2. That is, if you cut off the tree at node n, 
 * the two trees whould be identical.
 * */
package jinfeng;

import java.util.ArrayList;

public class SubTree {
    
	public static void main(String[] args) {
		
		
		//create big tree
		Node result1 = createBinarySearchTree(10);
		
        if (result1 !=null){
		
		
		//create small tree
		Node result2 = null;
		
		Node a1 = new Node(7);
		Node a2 = new Node(5);
		Node a3 = new Node(8);
		Node a4 = new Node(6);
		Node a5 = new Node(9);
		
		a1.left = a2;
		a1.right = a3;
		a2.right = a4;
		a3.right = a5;
		
		result2 = a1;
		
		System.out.println("Result2 is the SubTree of Result1? " + subTree(result1, result2));
		
        }
        
		
	}
	
	public static boolean subTree(Node bigTree, Node smallTree){
		ArrayList<Node> sameNode = sameNode(bigTree, smallTree);
		
		if (sameNode.size() == 0) return false;
		else {
			Node temp = null;
			for (int i = 0; i < sameNode.size(); i++){
				
				temp = sameNode.get(i);
				
				if (compareTwoTree(temp, smallTree) == true)
					return true;
			}
			return false;
		}
	}

	public static boolean compareTwoTree(Node a, Node b){//true - same,value of a and b should be the same
		if (a == null && b == null){
			return true;
		}
		if (a != null && b != null){
			if (a.item == b.item) 
				return compareTwoTree(a.left, b.left) && compareTwoTree(a.right, b.right);
			else return false;
		}
		if (a == null || b == null){
			return false;
		}
		else {return false;}
		
	}
	
	public static ArrayList<Node> sameNode(Node bigTree, Node smallTree){
		 ArrayList<Node> ll = new ArrayList<Node>();
		// add node equal to node small tree to the ArrayList
		traverseTree(bigTree, smallTree, ll);
		
		return ll;
	}
	
	public static void traverseTree(Node root, Node value, ArrayList<Node> ll ){
		
		if (root == null){} else{
			if (root.item == value.item) {
				ll.add(root);
				
				}
			
			if (root.left != null) traverseTree(root.left, value, ll);
			if (root.right != null) traverseTree(root.right, value, ll);
			
			
		}
		
	}
	public static Node createBinarySearchTree(int size){
	    Node root = null;
		if (size == 1) {
			root = new Node((size-1)/2);
			return root;
		}
		else {// size > 1
			int mid = (size-1)/2;
			 root = new Node(mid);
			recursionTree(0, mid - 1, root); 
			recursionTree(mid + 1, size - 1, root); 
			return root;
		}
	}
	
	public static void recursionTree(int startIndex, int endIndex, Node root) {
		
		if (startIndex <= endIndex){
			int mid = (startIndex + endIndex)/2;
			distribute(mid, root);
			
			recursionTree(startIndex, mid - 1, root);
			recursionTree(mid + 1, endIndex, root);
		} 
	}
	
	public static void distribute(int current, Node temp){
		if (current < temp.item){
			if (temp.left == null) {temp.left = new Node(current);}
			else {
				temp = temp.left;
				distribute(current, temp);
			}
		}else if (current > temp.item){
			if ( temp.right == null){temp.right = new Node(current);}
			else {
				temp = temp.right;
				distribute(current, temp);
			}
		}
	}
}

class Node{
	int item;
	Node left;
	Node right;
	Node(int i){
		item = i;
	}
	@Override
	public boolean equals(Object obj){
		Node x = (Node)obj;
		if (this == obj) return true;
		if (this.item == x.item) return true;
		else return false;
	}
}
/*cc150 4.4
 * Given a binary tree, design an algorithm which creates a linkedlist of all the
 * nodes at each depth (if you have a tree with depth D, you'll have D linked lists.).
 * */
/*solution: Create an arraylist of linked list.*/
package jinfeng;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListEachDepth {

	public static void main(String[] args) {
		Node root;
		root = createBinaryTree();
		BTreeToLinkedLists(root);

	}

	public static Node createBinaryTree(){
		Node a0 = new Node(0);
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(5);
		Node a6 = new Node(6);
		Node a7 = new Node(7);
		Node a8 = new Node(8);
		
		a0.left = a1;
		a0.right = a2;
		a1.left = a3;
		a1.right = a4;
		a2.left = a5;
		a2.right = a6;
		a3.left = a7;
		a3.right = a8;
	
		return a0;
	}
	
	/*
	 *put all nodes in the binary tree into the linkedlists according to the depth of the node 
	 * */
	public static void BTreeToLinkedLists(Node root){
		ArrayList<LinkedList<Node>> arr = new ArrayList<LinkedList<Node>>();
		
		//go through all nodes
		int depth = 0;
		process(root,depth, arr);
		removeNull(arr);
		displayArrayLists(arr);
	}
	
	public static void removeNull(ArrayList<LinkedList<Node>> arr){
		int size = arr.size();
		if (arr.get(size - 1).size() == 0) 
			arr.remove(size - 1);
	}
	
	public static void process(Node x, int depth, ArrayList<LinkedList<Node>> arr){
		if (x != null){
			// create a new LinkedList according to the depth if not exists
			if (arr.size()-1 <= depth ){
				arr.add(new LinkedList<Node>());
				}
			LinkedList<Node> temp = arr.get(depth);
			temp.add(x);
			depth++;
			process(x.left, depth, arr);
			process(x.right, depth, arr);
		
		}
		
	}
	
	public static void displayArrayLists(ArrayList<LinkedList<Node>> arr){
		int size = arr.size();
		for (int i = 0; i < size; i++){
			System.out.print("Index " + i +": ");
			LinkedList<Node> ll = arr.get(i);
			for (int j = 0; j < ll.size(); j++){
				System.out.print(ll.get(j).getItem() + " ");
			}
		}
		System.out.println();
	}
}

class Node {
	public int item;
	Node left;
	Node right;
	
	Node(int i){
		item = i;
		left = null;
		right = null;
	}
	public int getItem(){
		return item;
	}
}
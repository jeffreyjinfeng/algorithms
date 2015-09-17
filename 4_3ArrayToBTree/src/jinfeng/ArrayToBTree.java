/*cc150 4.3
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 * */

package jinfeng;

import java.util.ArrayList;

public class ArrayToBTree {

	public static void main(String[] args) {
		ArrayList<Integer> arr = initArray(10);
		Node root = arrayToBinaryTree(arr);
		displayBinaryTree(root);
		
		
	}
	
	public static ArrayList<Integer> initArray(int size){
		ArrayList<Integer> itArray = new ArrayList<Integer>(size); 
		for (int i = 0; i < size; i++){
			itArray.add(i);
		}
		return itArray;
	}

	public static Node arrayToBinaryTree(ArrayList<Integer> arr){
		int size = arr.size();
		Node root = new Node(arr.get(size/2));
		//arr.remove((size - 1)/2);
		
		if (size == 1 ) return root;
		process(arr, 0, size - 1, root);
		return root;
	}
	
	public static void process(ArrayList<Integer> arr, int startIndex, int endIndex, Node temp){
		int mid;
		if (startIndex <= endIndex){
			mid = (startIndex + endIndex)/2;
			System.out.println(mid);//test
			distribute(mid, temp);
			process(arr, startIndex, mid - 1, temp);
			process(arr, mid+1, endIndex, temp);
		} 
		
	}
	
	public static void distribute(int current, Node temp){//add a new item to a existing Btree started from Node temp
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
	
	public static void displayBinaryTree(Node root){
		
	}
	
}


class Node {
	public int item;
	public Node left;
	public Node right;
	Node(int i){
		item = i;
	}
}
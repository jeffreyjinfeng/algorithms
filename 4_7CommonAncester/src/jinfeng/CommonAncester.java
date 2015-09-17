/*cc150 4.7
 * Design an algorithm and write code to find the first common ancestor of two nodes 
 * in a binary tree. Avoid storing additional nodes in a data structure. Note:
 * this is not necessarily a binary search tree.
 * */

package jinfeng;

public class CommonAncester {

	public static void main(String[] args) {
		//Create a binary Tree
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
		
		// return the common Ancestor
		Node result = findCommonAncestor(a4, a8);
		
		// display the common ancestor
		if (result == null){
			System.out.println("No common ancestor");
		} else {
			System.out.println("Common ancestor is: " + result.item);
			
		}

	}

	public static Node findCommonAncestor(Node x, Node y){
		if (x.parent == null || y.parent == null ){
			return null;
		} else if (x.parent == y) return y.parent;
		else if (y.parent == x) return x.parent;
		else {
			// find the edges of x ->a
			int countx = 0;
			Node temp = x;
			while (temp.parent != null) {
				countx++;
				temp = temp.parent;
			}
			
			// find the edges of y -> b
			int county = 0;
			temp = y;
			while (temp.parent != null){
				county++;
				temp = temp.parent;
			}
			
			
			// take action based on the difference of a and b: got countx and county
			if (countx == county){
				while (x.parent != null){
					x = x.parent;
					y = y.parent;
					if (x == y){
						return x;
					} 
				}
			}else if (countx > county) {
				int diff = countx - county;
				for (int i = 0; i < diff; i++){
					x = x.parent;
				}
				
				while (x.parent != null){
					x = x.parent;
					y = y.parent;
					if (x == y){
						return x;
					} 
				}
			} else if (countx < county){
				int diff = county - countx;
				for (int i = 0; i < diff; i++){
					y = y.parent;
				}
				
				while (x.parent != null){
					x = x.parent;
					y = y.parent;
					if (x == y){
						return x;
					} 
				}
			} 
		}
		return null;
			
	}
}

class Node{
	public int item;
	Node left;
	Node right;
	Node parent;
	
	Node(int i){
		item = i;
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
package test;

import java.util.ArrayList;
/*
Level order traversal in specific order
			1
	2				3
4		5  	   6		 7

o/p : 1 2 3 4 7 5 6

*/


public class SpecificLevelOrder {

	static private  void  levelOrder(Node n){
		ArrayList<Node> nodeList = new ArrayList<Node>();
		nodeList.add(n);
		while(!nodeList.isEmpty()){
			int length = nodeList.size();
			int min = 0;
			int max  = length /2;
			if(length %2 != 0 && max != min)
				max += 1 ;
			for(int i=0,k=0;i<length;i++,k++){
				Node t = nodeList.get(i);
				if(k<max || max == 0 ){
					System.out.print(t.data + " ");
					if(i!=length-1-k){
						Node t1 = nodeList.get(length-1-k);
						System.out.print(t1.data + " ");
					}
				}
				nodeList.remove(i);
				i--;
				length--; 
				if(t.left != null)
					nodeList.add(t.left);
				if(t.right != null)
					nodeList.add(t.right);
			}
		}
	}
	public static void main(String[] args) {

		Node root = new Node(1);

		root.left        = new Node(2);
		root.right       = new Node(3);
		root.left.left  = new Node(4);
		root.left.right = new Node(5);
		root.right.left  = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left  = new Node(8);
		root.left.left.right  = new Node(9);
		root.left.right.left  = new Node(10);
		root.left.right.right  = new Node(11);
		root.right.left.left  = new Node(12);
		root.right.left.right  = new Node(13);
		root.right.right.left  = new Node(14);
		root.right.right.right  = new Node(15);
		root.left.left.left.left  = new Node(16);
		root.left.left.left.right  = new Node(17);
		root.left.left.right.left  = new Node(18);
		root.left.left.right.right  = new Node(19);
		root.left.right.left.left  = new Node(20);
		root.left.right.left.right  = new Node(21);
		root.left.right.right.left  = new Node(22);
		root.left.right.right.right  = new Node(23);
		root.right.left.left.left  = new Node(24);
		root.right.left.left.right  = new Node(25);
		root.right.left.right.left  = new Node(26);
		root.right.left.right.right  = new Node(27);
		root.right.right.left.left  = new Node(28);
		root.right.right.left.right  = new Node(29);
		root.right.right.right.left  = new Node(30);
		root.right.right.right.right  = new Node(31);
		levelOrder(root);


	}

}

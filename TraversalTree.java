package guvidsa;
import java.util.*;

public class TraversalTree {
	
	static class Node{
		int data;
		Node left,right;
		
		Node(int item){
			data=item;
			left=right=null;
		}
	}
	
	static class BinaryTree{
		Node root;
		BinaryTree(){
			root=null;
		}
		
		
	void inOrderTraversal(Node node) {
		if(node!=null) {
			inOrderTraversal(node.left);
			System.out.println(node.data+" ");
			inOrderTraversal(node.right);
		}
	}
		
	void preOrderTraversal(Node node) {
		if(node!=null) {
			System.out.println(node.data+" ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
		
	void postOrderTraversal(Node node) {
		if(node!=null) {			
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.data+" ");
		}
	}
		
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BinaryTree tree = new BinaryTree();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		

        System.out.println("In-order traversal:");
        tree.inOrderTraversal(tree.root);
        System.out.println("\nPre-order traversal:");
        tree.preOrderTraversal(tree.root);
        System.out.println("\nPost-order traversal:");
        tree.postOrderTraversal(tree.root);
	}

}

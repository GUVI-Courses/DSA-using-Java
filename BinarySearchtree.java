package guvidsa;

public class BinarySearchtree {
	
	static class TreeNode{
		int key;
		TreeNode left,right;
		
		public TreeNode(int item) {
			key=item;
			left=right=null;
			
		}
		
		
	}
	
	static class BinarySearchTree{
		private TreeNode root;
		
		public BinarySearchTree() {
			root=null;
		}
		
		
//		Insert Operation
		
		public TreeNode insert(TreeNode root,int key) {
			if(root==null) {
				root=new TreeNode(key);
				return root;
			}
			
			if(key<root.key) {
				root.left=insert(root.left,key);
			}
			else if(key>root.key) {
				root.right=insert(root.right,key);
			}
			
			return root;
		}
		
		public TreeNode delete(TreeNode root, int key) {
			if(root==null) {
				return root;
			}
			
			if(key<root.key) {
				root.left=delete(root.left,key);
			}
			else if(key>root.key) {
				root.right=delete(root.right,key);
			}
			else {
				if(root.left==null)
				{
					return root.right;
				}
				else if (root.right==null)
				{
					return root.left;
				}
				
				root.key=minValue(root.right);
				root.right=delete(root.right,root.key);
			}
			return root;
		}
		
		
		 // Helper function to find the minimum value node in a subtree
	    int minValue(TreeNode root) {
	        int minv = root.key;
	        while (root.left != null) {
	            minv = root.left.key;
	            root = root.left;
	        }
	        return minv;
	    }
	    
	    
	    
	    
	    // Utility method to print inorder traversal of BST
	    public void inorderTraversal(TreeNode root) {
	        if (root != null) {
	            inorderTraversal(root.left);
	            System.out.print(root.key + " ");
	            inorderTraversal(root.right);
	        }
	    }
	    
	 // Search operation
	    public TreeNode search(TreeNode root, int key) {
	        if (root == null || root.key == key)
	            return root;

	        if (root.key < key)
	            return search(root.right, key);

	        return search(root.left, key);
	    }

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    BinarySearchTree bst = new BinarySearchTree();
	        TreeNode root = null;

	        root = bst.insert(root, 50);
	        root = bst.insert(root, 30);
	        root = bst.insert(root, 20);
	        root = bst.insert(root, 40);
	        root = bst.insert(root, 70);
	        root = bst.insert(root, 60);
	        root = bst.insert(root, 80);

	        System.out.println("Inorder traversal of the BST:");
	        bst.inorderTraversal(root);

	        int keyToSearch = 40;
	        TreeNode searchedNode = bst.search(root, keyToSearch);
	        if (searchedNode != null)
	            System.out.println("\nFound " + keyToSearch + " in the BST.");
	        else
	            System.out.println("\n" + keyToSearch + " not found in the BST.");

	        int keyToDelete = 30;
	        root = bst.delete(root, keyToDelete);
	        System.out.println("Inorder traversal after deletion of " + keyToDelete + ":");
	        bst.inorderTraversal(root);
		
		
		

	}

}

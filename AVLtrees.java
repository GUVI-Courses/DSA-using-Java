package guvidsa;

public class AVLtrees {

	static class TreeNode {
	    int key, height;
	    TreeNode left, right;

	    TreeNode(int d) {
	        key = d;
	        height = 1;
	        left = right = null;
	    }
	}
	static public class AVLTree {
	    TreeNode root;

	    // Get height of the tree
	    int height(TreeNode N) {
	        if (N == null)
	            return 0;
	        return N.height;
	    }
	 // Get balance factor of the node
	    int getBalance(TreeNode N) {
	        if (N == null)
	            return 0;
	        return height(N.left) - height(N.right);
	    }
	    
	    
	    // Right rotate subtree rooted with y
	    TreeNode rightRotate(TreeNode y) {
	        TreeNode x = y.left;
	        TreeNode T2 = x.right;

	        // Perform rotation
	        x.right = y;
	        y.left = T2;

	        // Update heights
	        y.height = Math.max(height(y.left), height(y.right)) + 1;
	        x.height = Math.max(height(x.left), height(x.right)) + 1;

	        // Return new root
	        return x;
	    }
	    
	    
	 // Left rotate subtree rooted with x
	    TreeNode leftRotate(TreeNode x) {
	        TreeNode y = x.right;
	        TreeNode T2 = y.left;

	        // Perform rotation
	        y.left = x;
	        x.right = T2;

	        // Update heights
	        x.height = Math.max(height(x.left), height(x.right)) + 1;
	        y.height = Math.max(height(y.left), height(y.right)) + 1;

	        // Return new root
	        return y;
	    }
	    
	    
	    
	    
	    // Insert a key in the AVL tree
	    TreeNode insert(TreeNode node, int key) {
	        // Perform normal BST insertion
	        if (node == null)
	            return (new TreeNode(key));

	        if (key < node.key)
	            node.left = insert(node.left, key);
	        else if (key > node.key)
	            node.right = insert(node.right, key);
	        else // Duplicate keys not allowed
	            return node;

	        // Update height of this ancestor node
	        node.height = 1 + Math.max(height(node.left), height(node.right));

	        // Get the balance factor of this ancestor node to check whether this node became unbalanced
	        int balance = getBalance(node);

	        // If this node becomes unbalanced, then there are 4 cases

	        // Left Left Case
	        if (balance > 1 && key < node.left.key)
	            return rightRotate(node);

	        // Right Right Case
	        if (balance < -1 && key > node.right.key)
	            return leftRotate(node);

	        // Left Right Case
	        if (balance > 1 && key > node.left.key) {
	            node.left = leftRotate(node.left);
	            return rightRotate(node);
	        }

	        // Right Left Case
	        if (balance < -1 && key < node.right.key) {
	            node.right = rightRotate(node.right);
	            return leftRotate(node);
	        }

	        // return the unchanged node pointer
	        return node;
	    }
	    
	    TreeNode minValueNode(TreeNode node) {
	        TreeNode current = node;

	        /* loop down to find the leftmost leaf */
	        while (current.left != null)
	            current = current.left;

	        return current;
	    }
	    
	    
	    // Delete a node from AVL tree
	    TreeNode deleteNode(TreeNode root, int key) {
	        // Perform standard BST delete
	        if (root == null)
	            return root;

	        if (key < root.key)
	            root.left = deleteNode(root.left, key);
	        else if (key > root.key)
	            root.right = deleteNode(root.right, key);
	        else {
	            // node with only one child or no child
	            if ((root.left == null) || (root.right == null)) {
	                TreeNode temp = null;
	                if (temp == root.left)
	                    temp = root.right;
	                else
	                    temp = root.left;

	                // No child case
	                if (temp == null) {
	                    temp = root;
	                    root = null;
	                } else // One child case
	                    root = temp; // Copy the contents of the non-empty child

	            } else {
	                // node with two children: Get the inorder successor (smallest in the right subtree)
	                TreeNode temp = minValueNode(root.right);

	                // Copy the inorder successor's data to this node
	                root.key = temp.key;

	                // Delete the inorder successor
	                root.right = deleteNode(root.right, temp.key);
	            }
	        }

	        // If the tree had only one node then return
	        if (root == null)
	            return root;

	        // Update height of the current node
	        root.height = Math.max(height(root.left), height(root.right)) + 1;

	        // Get the balance factor of this node to check whether this node became unbalanced
	        int balance = getBalance(root);

	        // If this node becomes unbalanced, then there are 4 cases

	        // Left Left Case
	        if (balance > 1 && getBalance(root.left) >= 0)
	            return rightRotate(root);

	        // Left Right Case
	        if (balance > 1 && getBalance(root.left) < 0) {
	            root.left = leftRotate(root.left);
	            return rightRotate(root);
	        }

	        // Right Right Case
	        if (balance < -1 && getBalance(root.right) <= 0)
	            return leftRotate(root);

	        // Right Left Case
	        if (balance < -1 && getBalance(root.right) > 0) {
	            root.right = rightRotate(root.right);
	            return leftRotate(root);
	        }

	        return root;
	    }


	    // Print inorder traversal of the AVL tree
	    void inorderTraversal(TreeNode root) {
	        if (root != null) {
	            inorderTraversal(root.left);
	            System.out.print(root.key + " ");
	            inorderTraversal(root.right);
	        }
	    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
           30
          /  \
        20   40
       /  \     \
      10  25    50
         */

        System.out.println("Inorder traversal of the constructed AVL tree is ");
        tree.inorderTraversal(tree.root);

        int keyToDelete = 20;
        tree.root = tree.deleteNode(tree.root, keyToDelete);

        System.out.println("\n\nInorder traversal after deletion of " + keyToDelete + " is ");
        tree.inorderTraversal(tree.root);
	}

}
}
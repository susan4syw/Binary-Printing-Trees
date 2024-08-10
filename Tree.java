/*
 * Name: Susan Wu
 * Date: 2024-8-9
 * Project: Binary Search Tree Implementation
 * Purpose: Defines the TreeNode class used for constructing a binary search tree.
 *          Includes methods for inserting, removing, and searching nodes in the tree.
 */
// TreeNode and Tree class declarations for a binary search tree
class TreeNode<T extends Comparable<T>> {
   TreeNode<T> leftNode; // left node
   T data; // node value
   TreeNode<T> rightNode; // right node

   // Constructor initializes data and makes this a leaf node
   public TreeNode(T nodeData) {
       data = nodeData;
       leftNode = rightNode = null; // node has no children
   }

   // Locate insertion point and insert new node; ignore duplicate values
   public void insert(T insertValue) {
       if (insertValue.compareTo(data) < 0) {
           if (leftNode == null) {
               leftNode = new TreeNode<>(insertValue);
           } else {
               leftNode.insert(insertValue);
           }
       } else if (insertValue.compareTo(data) > 0) {
           if (rightNode == null) {
               rightNode = new TreeNode<>(insertValue);
           } else {
               rightNode.insert(insertValue);
           }
       }
   }

   public TreeNode<T> remove(T removeValue) {
      if (removeValue.compareTo(data) < 0) {
         // Remove from the left subtree
         if (leftNode != null) {
            leftNode = leftNode.remove(removeValue);
         }
      } else if (removeValue.compareTo(data) > 0) {
         // Remove from the right subtree
         if (rightNode != null) {
            rightNode = rightNode.remove(removeValue);
         }
      } else {
         // Node to be removed found
         if (leftNode == null) {
            return rightNode; // No left child, return right child
         } else if (rightNode == null) {
            return leftNode; // No right child, return left child
         } else {
            // Node with two children
            TreeNode<T> minNode = findMin(rightNode);
            data = minNode.data;
            rightNode = rightNode.remove(minNode.data);
         }
      }
      return this;
   }

  // Find the minimum value node in a subtree
   private TreeNode<T> findMin(TreeNode<T> node) {
      while (node.leftNode != null) {
         node = node.leftNode;
      }
      return node;
   }

  // Search for a node with a given value
   public boolean search(T searchValue) {
      if (searchValue.compareTo(data) < 0) {
         return leftNode != null && leftNode.search(searchValue);
      } else if (searchValue.compareTo(data) > 0) {
         return rightNode != null && rightNode.search(searchValue);
      } else {
         return true; // Node found
      }
   }
}

public class Tree<T extends Comparable<T>> {
   private TreeNode<T> root;

   // Constructor initializes an empty Tree
   public Tree() {
       root = null;
   }
   

   // Insert a new node in the binary search tree
   public void add(T value) {
      if (root == null) {
      root = new TreeNode<>(value);
      } else {
         root.insert(value);
      }
   }

   // Recursive method to print the tree row by row
   public void outputTree(int totalSpace) {
       outputTreeHelper(root, totalSpace >= 0 ? totalSpace : 0);
   }

   // Recursive method to print the tree
   private void outputTreeHelper(TreeNode<T> currentNode, int spaces) {
       if (currentNode != null) {
           // Traverse the right subtree first (this will print the rightmost node at the top)
           outputTreeHelper(currentNode.rightNode, spaces + 5);

           // Print the current node with spaces
           for (int k = 0; k < spaces; k++) {
               System.out.print(" ");
           }
           System.out.println(currentNode.data);

           // Traverse the left subtree
           outputTreeHelper(currentNode.leftNode, spaces + 5);
       }
   }
   

// Remove a node from the tree
public void remove(T value) {
   if (root != null) {
       root = root.remove(value);
   }
}

// Search for a node with a given value
public boolean search(T value) {
   return root != null && root.search(value);
}

   // begin preorder traversal
   public void preorderTraversal() {
      preorderHelper(root);
   }

      // recursive method to perform preorder traversal
   private void preorderHelper(TreeNode<T> node) {
      if (node == null) {
         return;
      }
      System.out.printf("%s ", node.data); // output node data
      preorderHelper(node.leftNode); // traverse left subtree
      preorderHelper(node.rightNode); // traverse right subtree
   }
   // begin inorder traversal
   public void inorderTraversal() {
      inorderHelper(root);
   }
   // recursive method to perform inorder traversal
   private void inorderHelper(TreeNode<T> node) {
      if (node == null) {
         return;
      }
      inorderHelper(node.leftNode); // traverse left subtree
      System.out.printf("%s ", node.data); // output node data
      inorderHelper(node.rightNode); // traverse right subtree
   }
   // begin postorder traversal
   public void postorderTraversal() {
      postorderHelper(root);
   }
   // recursive method to perform postorder traversal
   private void postorderHelper(TreeNode<T> node) {
      if (node == null) {
         return;
      }
      postorderHelper(node.leftNode); // traverse left subtree
      postorderHelper(node.rightNode); // traverse right subtree
      System.out.printf("%s ", node.data); // output node data
   }
   // begin printing tree
   public void outputTree(int totalSpace) {
      outputTreeHelper(root, totalSpace>= 0 ? totalSpace : 0);
   }
   // recursive method to print tree
   private void outputTreeHelper(TreeNode<T> currentNode, int spaces) {
   // recursively print right branch, then left
      if (currentNode != null) {
         outputTreeHelper(currentNode.rightNode, spaces + 5);
         for (int k = 0; k <spaces; k++) {
            System.out.print(" ");
         }
      System.out.println(currentNode.data);
      outputTreeHelper(currentNode.leftNode, spaces + 5);
      }
   }
}

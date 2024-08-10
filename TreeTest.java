public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        int[] values = {97, 39, 72, 83, 8, 58, 17, 5, 71, 30};
        for (int value : values) {
            tree.add(value);
        }

        // Perform and print different tree traversals
        System.out.println("Preorder traversal:");
        tree.preorderTraversal();
        System.out.println();
        System.out.println("\nInorder traversal:");
        tree.inorderTraversal();
        System.out.println();
        System.out.println("\nPostorder traversal:");
        tree.postorderTraversal();
        System.out.println();

        // Print the visual representation of the tree
        System.out.println("\nTree structure:");
        tree.outputTree(0);

        System.out.println("Searching for 58: " + tree.search(58));
        System.out.println("Searching for 100: " + tree.search(100));

        System.out.println("Removing 72:");
        tree.remove(72);
        tree.outputTree(0);

        System.out.println("Searching for 72: " + tree.search(72));
    }
}
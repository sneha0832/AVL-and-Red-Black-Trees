public class binarytesting{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Test isEmpty on an empty tree
        System.out.println("Is tree empty? " + tree.isEmpty()); // Expected: true

        // Insert some values into the tree
        tree.insert("k");
        tree.insert("e");
        tree.insert("y");
        tree.insert("a");
        tree.insert("z");
        tree.insert("m");
        tree.insert("n");
        tree.insert("t");
        tree.insert("f");

        // Test isEmpty after inserting values
        System.out.println("Is tree empty? " + tree.isEmpty()); // Expected: false

        // Display tree using inorder traversal (should be sorted)
        System.out.print("Inorder traversal: ");
        tree.inorder(); 
        System.out.println();

        // Display tree using preorder traversal
        System.out.print("Preorder traversal: ");
        tree.preorder(); 
        System.out.println();

        // Display tree using postorder traversal
        System.out.print("Postorder traversal: ");
        tree.postorder(); 
        System.out.println();

        // Test countNodes
        System.out.println("Number of nodes: " + tree.countNodes());

        // Test search
        System.out.println("Search for e: " + tree.search("e")); 
        System.out.println("Search for v: " + tree.search("v")); 

        // Test remove
        System.out.println("Removing a (leaf node)");
        tree.remove("a");
        tree.inorder(); 
        System.out.println();

        System.out.println("Removing e (node with one child)");
        tree.remove("e");
        tree.inorder(); 
        System.out.println();

        System.out.println("Removing m (node with two children)");
        tree.remove("v");
        tree.inorder(); 
        System.out.println();

        // Test countNodes after deletions
        System.out.println("Number of nodes after deletions: " + tree.countNodes()); 
    }
}
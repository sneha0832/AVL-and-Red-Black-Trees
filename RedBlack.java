//Red Balck tree class
//Sneha patel
public class RedBlack extends BinaryTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public RedBlack() {
        super();
    }
    //to rotate left
    private BinNode rotateLeft(BinNode r) {
        BinNode newRoot = r.getRight();//new root is the right child of current node
        r.setRight(newRoot.getLeft());
        if (newRoot.getLeft() != null) {//if the new roots left child is not null update its parent
            newRoot.getLeft().setParent(r);
        }
        newRoot.setParent(r.getParent());//set the new root's parent
        
        if (r.getParent() == null) {// update the parent of the current node's position
            setRoot(newRoot);// if the current node is the root, update the root
        } else if (r == r.getParent().getLeft()) {
            r.getParent().setLeft(newRoot);
        } else {
            r.getParent().setRight(newRoot);
        }
        //rotate by setting the new root's left child as the current node
        newRoot.setLeft(r);
        r.setParent(newRoot);

        return newRoot;
    }
    //to rotate right
    private BinNode rotateRight(BinNode r) {
        BinNode newRoot = r.getLeft();
        r.setLeft(newRoot.getRight());
        if (newRoot.getRight() != null) {//if the new roots right child is not null update its parent
            newRoot.getRight().setParent(r);
        }
        newRoot.setParent(r.getParent());

        if (r.getParent() == null) {
            setRoot(newRoot);
        } else if (r == r.getParent().getRight()) {
            r.getParent().setRight(newRoot);
        } else {
            r.getParent().setLeft(newRoot);
        }

        newRoot.setRight(r);
        r.setParent(newRoot);

        return newRoot;
    }
    //recursive helper method
    private BinNode insertHelper(BinNode root, String data) {
        if (root == null) {//if the root is null make new
            BinNode newNode = new BinNode(data);
            newNode.setColor(RED);//new node is always red
            return newNode;
        }
        //find its right position
        if (data.compareTo(root.getData()) < 0) {
            root.setLeft(insertHelper(root.getLeft(), data));
            root.getLeft().setParent(root);
        } else if (data.compareTo(root.getData()) > 0) {
            root.setRight(insertHelper(root.getRight(), data));
            root.getRight().setParent(root);
        }

        return root;
    }

    @Override
    public void insert(String data) {
        setRoot(insertHelper(getRoot(), data));//do the insertion
        balanceInsert(getRoot());//then balance the tree
    }

    private void balanceInsert(BinNode node) {//help from geeks for geeks
        BinNode parent, grandParent;
        // check if the current node and its parent violate Red-Black properties
        while (node != null && node != getRoot() && node.getParent().getColor() == RED) {
            parent = node.getParent();
            grandParent = parent.getParent();
    
            if (parent == grandParent.getLeft()) {//// If the parent is the left child of the grandparent
                BinNode uncle = grandParent.getRight();
    
                if (uncle != null && uncle.getColor() == RED) {// Case 1: uncle is red, recolor and move up the tree
                    grandParent.setColor(RED);
                    parent.setColor(BLACK);
                    uncle.setColor(BLACK);
                    node = grandParent;// Move the current node up to the grandparent
                } else {
                    if (node == parent.getRight()) {// Case 2: node is the right child of the parent, rotate left
                        rotateLeft(parent);
                        node = parent;
                        parent = node.getParent();
                    }
                    rotateRight(grandParent);// Case 3: rotate right at the grandparent and recolor
                    boolean tempColor = parent.getColor();
                    parent.setColor(grandParent.getColor());
                    grandParent.setColor(tempColor);
                    node = parent;
                }
            } else {
                BinNode uncle = grandParent.getLeft();//when the parent is the right child of the grandparent
    
                if (uncle != null && uncle.getColor() == RED) {
                    grandParent.setColor(RED);
                    parent.setColor(BLACK);
                    uncle.setColor(BLACK);
                    node = grandParent;
                } else {
                    if (node == parent.getLeft()) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.getParent();
                    }
                    rotateLeft(grandParent);
                    boolean tempColor = parent.getColor();
                    parent.setColor(grandParent.getColor());
                    grandParent.setColor(tempColor);
                    node = parent;
                }
            }
        }

        getRoot().setColor(BLACK);//make sure that the root is always black
    }

    @Override
    public void remove(String data) {
        BinNode node = deleteHelper(getRoot(), data);
        if (node != null) {
            balanceDelete(node);
            if (getRoot() != null) {
                getRoot().setColor(BLACK); // Ensure root is always black
            }
        }
    }

    private BinNode deleteHelper(BinNode root, String data) {
        if (root == null) {
            return null;
        }
        //search the node to delete
        if (data.compareTo(root.getData()) < 0) {
            root.setLeft(deleteHelper(root.getLeft(), data));
        } else if (data.compareTo(root.getData()) > 0) {
            root.setRight(deleteHelper(root.getRight(), data));
        } else {
            if (root.getLeft() == null || root.getRight() == null) {//node has no or one child
                return replaceNode(root, (root.getLeft() != null) ? root.getLeft() : root.getRight());
            } else {
                BinNode successor = findMin(root.getRight());//node has two childs
                root.setData(successor.getData());
                root.setRight(deleteHelper(root.getRight(), successor.getData()));
            }
        }
        return root;
    }

    private BinNode replaceNode(BinNode node, BinNode replacement) {
        if (node.getParent() == null) {
            setRoot(replacement);// if node is the root, replace it with the replacement
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(replacement);
        } else {
            node.getParent().setRight(replacement);
        }
        if (replacement != null) {
            replacement.setParent(node.getParent());
        }
        return node;
    }

    private BinNode findMin(BinNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private void balanceDelete(BinNode node) {
        while (node != getRoot() && !node.getColor()) {// while the node is not the root and it is black
            BinNode parent = node.getParent();
            if (node == parent.getLeft()) {
                BinNode sibling = parent.getRight();

                if (sibling.getColor()) {// Case 1: sibling is red, rotate left and fix colors
                    sibling.setColor(false);//sibling to black
                    parent.setColor(true);//parent to red
                    rotateLeft(parent);//
                    sibling = parent.getRight();//update sibling after rotation
                }
                
                if (!sibling.getLeft().getColor() && !sibling.getRight().getColor()) {// Case 2: both children of sibling are black, move up the tree
                    sibling.setColor(true);
                    node = parent;// move node up to the parent for further balancing
                } else {// Case 3: Fixing right child of sibling
                    if (!sibling.getRight().getColor()) {//right child of sibling is black, rotate right and recolor
                        sibling.getLeft().setColor(false);
                        sibling.setColor(true);
                        rotateRight(sibling);
                        sibling = parent.getRight();
                    }//perform final color adjustments and rotate left
                    sibling.setColor(parent.getColor());
                    parent.setColor(false);
                    sibling.getRight().setColor(false);
                    rotateLeft(parent);
                    node = getRoot();
                }
            } else {
                BinNode sibling = parent.getLeft();//when the node is on the right

                if (sibling.getColor()) {//if sibling is red, rotate right on the parent and recolor
                    sibling.setColor(false);
                    parent.setColor(true);
                    rotateRight(parent);
                    sibling = parent.getLeft();
                }

                if (!sibling.getRight().getColor() && !sibling.getLeft().getColor()) {//if both children of sibling are black, recolor and move up the tree
                    sibling.setColor(true);
                    node = parent;
                } else {//if at least one child of sibling is red
                    if (!sibling.getLeft().getColor()) {// if Lfft child of sibling is black, rotate left and recolor
                        sibling.getRight().setColor(false);
                        sibling.setColor(true);
                        rotateLeft(sibling);
                        sibling = parent.getLeft();
                    }
                    sibling.setColor(parent.getColor());//perform final color adjustments and rotate right
                    parent.setColor(false);
                    sibling.getLeft().setColor(false);
                    rotateRight(parent);
                    node = getRoot();
                }
            }
        }
        node.setColor(false);// make the current node black
    }
}

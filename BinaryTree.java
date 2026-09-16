//Binary Tree class
//Sneha Patel
/**
 * An ordered binary tree class.
 * TO DO:
 * 1) Complete the methods indicated.
 * 2) Add a remove method that eliminates the node of a given value
 *    (parameter = data to find and kill; return = void)
 *
 * @author ( )
 * @version (2023)
 */
public class BinaryTree
{
    private BinNode root; 
    
    /**
     * default constructor 
     */
//     public BinaryTree(){
//           root = new BinNode()
//     }
    public BinaryTree()
    {
        root = null; 
    }

    public BinNode getRoot(){
        return this.root;
    }
    public void setRoot(BinNode root){
     this.root = root;
    }
    
     /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return this.root == null;
    }
     /* Functions to insert data */
    public void insert(String data)
    {
         this.root = insert(this.root, data);
    }
    /* Function to insert data recursively */
    private BinNode insert(BinNode node, String data)
    {
         if (node == null)
             node = new BinNode(data);
         else
         {
             // write this!
             if(data.compareTo(node.getData())<0){//if the data is less than the current data move left and if greater than move right
               node.setLeft(insert(node.getLeft(), data));
             }else{
               node.setRight(insert(node.getRight(), data));
             }
         }
         return node;
    }     
    /* Function to count number of nodes */
    public int countNodes()
    {
         return countNodes(this.root);
    }
     /* Function to count number of nodes recursively */
    private int countNodes(BinNode r)
    {
        int count = 0; 
        if(r == null){//if the node is null retuen 0
          return 0;
        }
        //write this!
        count = 1;//count this node plus the left and right
        count += countNodes(r.getLeft());
        count += countNodes(r.getRight());
        return count;
    }
    /* Function to search for an element */
    public boolean search(String val)
    {
         return search(this.root, val);
    }
    /* Function to search for an element recursively */
    private boolean search(BinNode r, String val)
    {
         // write this!
         if(r == null){//check if node is null before making comparisons
          return false;
         }
         if(val.compareTo(r.getData())==0){//if its the current node return true
               return true;
         }else if(val.compareTo(r.getData())<0){//if the data you are finding is less than current go left
          return search(r.getLeft(), val);
         }else if(val.compareTo(r.getData())>0){//if the data you are finding is greater than current go right
          return search(r.getRight(), val);
         }
         return false;         
    }
    /* Function for inorder traversal */
    public void inorder()
    {
         inorder(this.root);
    }
    private void inorder(BinNode r)
    {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
         preorder(root);
    }
    private void preorder(BinNode r)
    {
         if (r != null)
         {
             System.out.print(r.getData() +" ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
         postorder(root);
    }
    private void postorder(BinNode r)
    {
         if (r != null)
         {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +" ");
         }
    }
    public void remove(String val){
          helperremove(root, val);
    }
    private BinNode helperremove(BinNode node, String val){
          if(node == null){
               return null;
          }
          if(val.compareTo(node.getData()) < 0){//if the data you are finding is less than current go left
               node.setLeft(helperremove(node.getLeft(), val));
         }else if(val.compareTo(node.getData()) > 0){//if the data you are finding is greater than current go right
               node.setRight(helperremove(node.getRight(), val));
          }else{
               if(node.getLeft()== null){//if no left child return right child
                    return node.getRight();
               }else if(node.getRight() == null){//if no right child return left child
                    return node.getLeft();
               }else{//if the node to be deleted is found
                    BinNode swap = node.getRight();//initializes the swap variable to the right child of the current node
                    while(swap.getLeft() != null){
                         swap = swap.getLeft();
                    }
                    node.setData(swap.getData());
                    node.setRight(helperremove(node.getRight(),swap.getData()));
               }
          }
          return node;
    }

}

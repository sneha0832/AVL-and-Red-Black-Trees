//AVL tree class
//Sneha patel
public class AVL extends BinaryTree{
    // Default constructor
    public AVL() {
        super();  // Calls the BinaryTree's constructor, if there is one
        
    }

    private int Height(BinNode r) {
        if (r == null) {
            return 0;
        }
        return r.getHeight();
    }

    //function to right rotate
    private BinNode rightRotate(BinNode r){
        BinNode newRoot = r.getLeft();
        BinNode rightOfNewRoot = newRoot.getRight();
        //do rotation
        newRoot.setRight(r);
        r.setLeft(rightOfNewRoot);
        //update heights
        r.setHeight(1 + Math.max(Height(r.getRight()),Height(r.getLeft())));
        newRoot.setHeight(1 + Math.max(Height(newRoot.getRight()),Height(newRoot.getLeft()))); 
        //return 
        return newRoot;
    }

    private BinNode leftRotate(BinNode r){
        BinNode newRoot = r.getRight();
        BinNode leftOfNewRoot = newRoot.getLeft();
        newRoot.setLeft(r);//do rotation
        r.setRight(leftOfNewRoot);
        //update heights
        r.setHeight(1 + Math.max(Height(r.getRight()),Height(r.getLeft())));
        newRoot.setHeight(1 + Math.max(Height(newRoot.getRight()),Height(newRoot.getLeft()))); 
        return newRoot;
        
    }

    private int heightDifference(BinNode r){
        if(r == null){
            return 0;
        }
        return Height(r.getLeft()) - Height(r.getRight());
    }

    @Override
    public void remove(String val){
        helperRemove(getRoot(), val); 
    }

    private BinNode helperRemove(BinNode r, String val){
          if(r == null){
            return null;
          }
          if(val.compareTo(r.getData()) < 0){//if the data you are finding is less than current go left
            r.setLeft(helperRemove(r.getLeft(), val));
      }else if(val.compareTo(r.getData()) > 0){//if the data you are finding is greater than current go right
        r.setRight(helperRemove(r.getRight(), val));
       }else{
            if(r.getLeft()== null){//if no left child return right child
                 return r.getRight();
            }else if(r.getRight() == null){//if no right child return left child
                 return r.getLeft();
            }else{//if the node to be deleted is found
                 BinNode swap = r.getRight();//initializes the swap variable to the right child of the current node
                 while(swap.getLeft() != null){
                      swap = swap.getLeft();
                 }
                 r.setData(swap.getData());
                 r.setRight(helperRemove(r.getRight(),swap.getData()));
            }
       }
       r.setHeight(1 + Math.max(Height(r.getLeft()), Height(r.getRight())));//reset heights
       return reBalance(r);
    }

    private BinNode reBalance(BinNode r){
        int height = heightDifference(r);
        if (height > 1){//heavy on left side
            if (heightDifference(r.getLeft()) < 0){
                r.setLeft(leftRotate(r.getLeft()));//left-right case
            }
            return rightRotate(r);//left-left case
        }
        if(height<-1){
            if(heightDifference(r.getRight())>0){
                r.setRight(rightRotate(r.getRight()));//right-left case
            }
            return leftRotate(r);//right-right case
        }
        return r;//already balanced
    }
    @Override
    public void insert(String val) {
        setRoot(insertHelper(getRoot(), val));  // Start the insertion from the root
    }

    private BinNode insertHelper(BinNode r, String val) {
        if (r == null) {
            return new BinNode(val);  // Create and return a new node if position is found
        }

        if (val.compareTo(r.getData()) < 0) {//if the data you are finding is less than current go left
            r.setLeft(insertHelper(r.getLeft(), val));  
        } else if (val.compareTo(r.getData()) > 0) {//if the data you are finding is greater than current go right
            r.setRight(insertHelper(r.getRight(), val)); 
        } else {
            return r;  // Duplicate values are not allowed (return current node)
        }

        r.setHeight(1 + Math.max(Height(r.getLeft()), Height(r.getRight())));  // Update height
        return reBalance(r);  // Rebalance tree if needed
    }
}
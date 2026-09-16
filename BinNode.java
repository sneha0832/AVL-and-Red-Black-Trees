//Binary node class
//Sneha Patel
/**
 * Node for a binary tree of strings.
 *
 * @author (lj)
 * @version (2023)
 */
public class BinNode
{
    private String data;
    private BinNode left;
    private BinNode right;
    private Integer height;
    private boolean color;
    private BinNode parent;
    
    public BinNode(){
        data = "";
        left = null;
        right = null;
        height = 1;
        color = true; //new nodes are initially red
        parent = null;
    }
    
    public BinNode(String d){
        data = d;
        left = null;
        right = null;
        height = 1;
        color = true;
        parent = null;
    }
    
    public void setData(String d){
        this.data = d;
    }
    public String getData(){
        return this.data;
    }
    public void setLeft(BinNode l){
        this.left = l;
    }
    public BinNode getLeft(){
        return this.left;
    }
    public void setRight(BinNode r){
        this.right = r;
    }
    public BinNode getRight(){
        return this.right;
    }
    public void setHeight(int h) {
        this.height = h;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getColor(){
        return color;
    }
    public void setColor(boolean color){
        this.color = color;
    }
    public BinNode getParent(){
        return parent;
    }
    public void setParent(BinNode parent){
        this.parent = parent;
    }

}

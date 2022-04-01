public class BinaryNode<T extends Comparable<T>> {

    T key;
    int height;
    BinaryNode<T> left, right, papa;


    
    public BinaryNode(T key) {
        this.key = key;
    }


    public T getKey() {
        return key;
    }
    public void setKey(T key) {
        this.key = key;
    }

    public int getHeight() {
        return getHeight(this);

    }

    private int getHeight(BinaryNode<T> node) {
        if(node==null) {
            return(0);
        } else {
            return(Math.max(getHeight(node.getLeft())+1, getHeight(node.getRight())+1 ));
        }

    }

    public BinaryNode<T> getLeft() {
        return left;
    }
    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }
    public BinaryNode<T> getRight() {
        return right;
    }
    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
    public void setPapa(BinaryNode<T> papa) {
        this.papa = papa;
    }

    public BinaryNode<T> getPapa() {
        return papa;
    }

    public int getBalanceFactor() {
        int res = 0;
        if(this.getRight()!=null&&this.getLeft()!=null) {
            res = this.getRight().getHeight()-this.getLeft().getHeight();
        } else if(this.getRight()!=null) {
            res = this.getRight().getHeight();
        } else if(this.getLeft()!=null) {
            res = -this.getLeft().getHeight();
        }

        return res;
        
    }

    public String toString() {
        return key.toString();
    }

    







    
}

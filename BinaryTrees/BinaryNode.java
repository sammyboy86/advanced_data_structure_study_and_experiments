public class BinaryNode<T> {
    private BinaryNode<T> right, left, papa;
    private T element;

    BinaryNode(T element) {
        this.element = element;

    }

    public BinaryNode<T> getRight() {
        return right;
    }



    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> getPapa() {
        return papa;
    }

    public void setPapa(BinaryNode<T> papa) {
        this.papa = papa;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int calculateHeight() {
        return calculateHeight(this);
        

    }

    private int calculateHeight(BinaryNode<T> current) {
        if(current==null) {
            return 0;

        } else {
            return(Math.max(calculateHeight(current.getRight()), calculateHeight(current.getLeft()))+1);
        }

    }
    

    public int calculateBalanceFactor() {
        return(this.getRight().calculateHeight()-this.getLeft().calculateHeight());


    }
    

    

}
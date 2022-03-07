public class BinaryAVLTree<T extends Comparable<T>> implements BinaryTreeADT<T> {

    private BinaryNode<T> root;

    BinaryAVLTree(BinaryNode<T> root) {
        this.root = root;

    }



    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void insert(T element) {
        BinaryNode<T> previous = null;
        BinaryNode<T> current = root;

        
        //find spot
        while(current!=null) {
            T currentElement = current.getElement();
            previous = current;

            if(currentElement.compareTo(element) <= 0) {
                
                current = current.getLeft();

            } else {
                current = current.getRight();

            }
                
        }

        //hang leaf
        if(previous==null) {
            root = new BinaryNode<T>(element);

        } else if (previous.getElement().compareTo(element)<=0) {
            previous.setLeft(new BinaryNode<T>(element));

        } else {
            previous.setRight(new BinaryNode<T>(element));

        }
        

        
        
    }


    //finish recursion
    public String toString() {
        return toString(root,0).toString();

    }

    private StringBuilder toString(BinaryNode<T> node, int level) {
        if(node==null) {

        } else {

        }



    }



    @Override
    public BinaryNode delete() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean find(T element) {
        // TODO Auto-generated method stub
        return false;
    }
    
}

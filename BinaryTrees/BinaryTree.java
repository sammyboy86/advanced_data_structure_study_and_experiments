public class BinaryTree<T extends Comparable<T>> implements BinaryTreeADT<T> {

    private BinaryNode<T> root;

    BinaryTree() {

    }

    BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(T elem) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void insert(T elem) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void eliminate(T elem) {
        // TODO Auto-generated method stub
        
    }
    
}

public class BinaryTree<T> implements BinaryTreeADT<T>{

    private NodoBin<T> raiz;
    int cont;

    public BinaryTree(NodoBin<T> raiz) {
        this.raiz = raiz;
        cont++;
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


    
}

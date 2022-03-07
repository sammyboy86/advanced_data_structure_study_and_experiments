public interface BinaryTreeADT<T> {

    public boolean isEmpty();
    public void insert();
    public BinaryNode<T> delete();
    public boolean find(T element);

}


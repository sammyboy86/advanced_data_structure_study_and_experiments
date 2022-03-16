public interface BinaryTreeADT<T extends Comparable<T>> {

    public boolean isEmpty();
    //public void insert(T element);
    public BinaryNode<T> delete();
    public boolean find(T element);

}


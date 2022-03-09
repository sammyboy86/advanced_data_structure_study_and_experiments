public class BinaryTreeMain {
    public static <T extends Comparable<T>> void main(String[] args) {

        BinaryNode<Integer> n1 = new BinaryNode<Integer>(16);
        n1.setLeft(new BinaryNode<Integer>(6));
        n1.setRight(new BinaryNode<Integer>(20));
        n1.getRight().setLeft(new BinaryNode<Integer>(18));

        



        BinaryAVLTree<Integer> testTree = new BinaryAVLTree<>(n1);

        testTree.insert(1);
        testTree.insert(-1);

        System.out.println(testTree.toString());



        


    }
}

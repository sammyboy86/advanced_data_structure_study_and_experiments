public class BinaryTreeMain {
    public static <T extends Comparable<T>> void main(String[] args) {


        BinaryNode<Integer> n1 = new BinaryNode<Integer>(16);

        BinaryAVLTree<Integer> testTree = new BinaryAVLTree<>(n1);

  
        

        testTree.insert(6);
        testTree.insert(20);
        testTree.insert(18);
        testTree.insert(1);
        testTree.insert(-1);
        testTree.insert(-3);

        System.out.println(testTree.toString());
        System.out.println(n1.calculateHeight());
        System.out.println(n1.calculateBalanceFactor());

        
        


    }
}

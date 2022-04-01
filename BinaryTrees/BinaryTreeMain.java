public class BinaryTreeMain {
    public static <T extends Comparable<T>> void main(String[] args) {


        BinaryNode<Integer> n1 = new BinaryNode<Integer>(16);

        BinaryAVLTree<Integer> testTree = new BinaryAVLTree<>(n1);

  
        

        testTree.insert(14);
        System.out.println(testTree.insert(15));
        testTree.insert(20);
        testTree.insert(21);





        System.out.println(testTree.toString());



        
        


    }
}

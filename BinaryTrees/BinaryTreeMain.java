public class BinaryTreeMain {
    public static <T extends Comparable<T>> void main(String[] args) {


        BinaryNode<Integer> n1 = new BinaryNode<Integer>(16);

        BinaryAVLTree<Integer> testTree = new BinaryAVLTree<>(n1);

  
        

        testTree.insert(6);
        testTree.insert(20);



        



       
        System.out.println(testTree.insert(1));
        System.out.println(testTree.insert(-1));
        System.out.println(testTree.insert(0));
        System.out.println(testTree.insert(-2));

        System.out.println(testTree.toString());



        
        


    }
}

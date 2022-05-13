public class BinaryTreeMain {
    public static <T extends Comparable<T>> void main(String[] args) {
        /*


        BinaryNode<Integer> n1 = new BinaryNode<Integer>(16);

        BinaryAVLTree<Integer> testTree = new BinaryAVLTree<>(n1);

  
        

        testTree.insert(14);
        System.out.println(testTree.insert(15));
        testTree.insert(20);
        testTree.insert(21);


<<<<<<< HEAD
        
=======

>>>>>>> a0d27342b55368c11b0793526dce4600f21be9eb


        System.out.println(testTree.toString());
        */

        HeapTree<Integer> heap = new HeapTree<Integer>();
        heap.insert(4);
        heap.insert(5);
        heap.insert(7);



        System.out.println(heap.toString());



        
        


    }
}

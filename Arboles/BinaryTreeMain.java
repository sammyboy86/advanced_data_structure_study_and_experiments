import java.util.Iterator;

import javax.sound.sampled.SourceDataLine;

public class BinaryTreeMain {
    public static <T extends Comparable<T>> void main(String[] args) {
        // TODO code application logic here

        System.out.println("---------------Arboles---------------");


        NodoBin<Character> n1 = new NodoBin<Character>('A');
        n1.setIzq(new NodoBin<Character>('B'));
        n1.getIzq().setIzq(new NodoBin<Character>('D'));
        n1.getIzq().setDer(new NodoBin<Character>('E'));
        n1.getIzq().getIzq().setIzq(new NodoBin<Character>('H'));
        n1.getIzq().getDer().setDer(new NodoBin<Character>('I'));

        BinaryTree t1 = new BinaryTree<Character>(n1);

        Iterator<Character> it = t1.nivelIterativo();
        



        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }

        System.out.println(t1.contiene('Z'));
        
    

        //System.out.println(t1.recorrePreorden());

    

        

        
        
    
               
    }

}

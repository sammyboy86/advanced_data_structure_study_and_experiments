import java.util.ArrayList;

public class BinaryAVLTree<T extends Comparable<T>> implements BinaryTreeADT<T> {

    private BinaryNode<T> root;

    BinaryAVLTree(BinaryNode<T> root) {
        this.root = root;

    }



    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void insert(T element) {
        BinaryNode<T> previous = null;
        BinaryNode<T> current = root;

        
        //find spot
        while(current!=null) {
            T currentElement = current.getElement();
            previous = current;

            if(currentElement.compareTo(element) <= 0) {
                
                current = current.getLeft();

            } else {
                current = current.getRight();

            }
                
        }

        //hang leaf
        if(previous==null) {
            root = new BinaryNode<T>(element);

        } else {
            if (previous.getElement().compareTo(element)<=0) {
                previous.setLeft(new BinaryNode<T>(element));
    
            } else {
                previous.setRight(new BinaryNode<T>(element));
               
            }

            


    

        }
        


        

        
    }


    //finish recursion
    public String toString() {
        ArrayList<BinaryNode<T>> nodes = new ArrayList<BinaryNode<T>>();
        StringBuilder string = new StringBuilder();
        nodes.add(root);

        if(root!=null) {
            string.append(root.getElement().toString());
        }
        

        while(!nodes.isEmpty()) {
            ArrayList<BinaryNode<T>> aux = new ArrayList<BinaryNode<T>>();
            string.append("\n");
            
            for(int i = 0; i<nodes.size(); i++) {
                BinaryNode<T> node = nodes.get(i);
                BinaryNode<T> left = node.getLeft();
                BinaryNode<T> right = node.getRight();
                if(left!=null) {
                    string.append(left.getElement().toString()).append(" ");
                    aux.add(left);

                }

                if (right!=null) {
                    string.append(right.getElement().toString()).append(" ");
                    aux.add(right);

                }

            
            }
            
            nodes = aux;


        }

        return(string.toString());
        
    }


    



    @Override
    public BinaryNode delete() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean find(T element) {
        // TODO Auto-generated method stub
        return false;
    }
    
}

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

    //@Override
    public int insert(T element) {
        int res = 0;


        BinaryNode<T> previous = null;
        BinaryNode<T> current = root;

        
        //find spot
        while(current!=null) {
            T currentElement = current.getElement();
            previous = current;

            if(element.compareTo(currentElement) <= 0) {
                
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
                previous.setRight(new BinaryNode<T>(element));
                previous.getRight().setPapa(previous);
    
            } else {
                previous.setLeft(new BinaryNode<T>(element));
                previous.getLeft().setPapa(previous);
               
            }

            //check imbalances     
            BinaryNode<T> aux = previous;
            boolean requiresRotation = false;
            while(!requiresRotation&&aux.getPapa()!=null) {
                if(Math.abs(aux.getPapa().calculateBalanceFactor())==2) {
                    requiresRotation = true;
                    res = (int) aux.getPapa().getElement();

                }
                aux=aux.getPapa();
            }



            //rotations!

            if(aux.calculateBalanceFactor()<-1) {
                //left left 
                if(aux.getLeft().getElement().compareTo(element)>0) {
                    BinaryNode<T> temp = aux.getLeft();                  
                    
                    if(temp.getRight()!=null) {
                        aux.setLeft(temp.getRight());
                        aux.getLeft().setPapa(aux);
                    } else {
                        aux.setLeft(null);

                    }

                    if(!aux.equals(root)) {
                        aux.getPapa().setLeft(temp);

                    }
 
                    temp.setPapa(aux.getPapa());
                    temp.setRight(aux);
                    aux.setPapa(temp);
                    

                    if(aux.equals(root)) {
                        this.root = temp;
                    }

                } else { //left right

                }

            } else if(aux.calculateBalanceFactor()>1) {
                //right right
                if(aux.getLeft().getElement().compareTo(element)<0) {

                } else { //right left
                    
                }
                
            }
    

        }
        return res; 


        
        
        

        


        



        
    }



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
    public BinaryNode<T> delete() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean find(T element) {
        // TODO Auto-generated method stub
        return false;
    }
    
}

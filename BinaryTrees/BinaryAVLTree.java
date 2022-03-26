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
            root.setPapa(null);

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


                } else {
                    aux=aux.getPapa();

                }
                
            }



            //rotations!
            if(requiresRotation) {

                if(aux.getPapa().calculateBalanceFactor()<-1) {
                    //left left 
                    if(aux.getElement().compareTo(element)>0) {

                        leftLeft(aux);

                    } else { //left right

                        res = leftRight(aux);
    
                    }
    
                } else if(aux.getPapa().calculateBalanceFactor()>1) {
                    //right right
                    if(aux.getElement().compareTo(element)<0) {
                        rightRight(aux);

                    } else { //right left

                        rightLeft(aux);




                        
                    }
                    
                }

            }

            
    

        }
        return res; 

        
    }

    private void leftLeft(BinaryNode<T> aux) {

        BinaryNode<T> temp = aux.getRight();

        aux.setRight(aux.getPapa());            
        aux.setPapa(aux.getPapa().getPapa());
        aux.getRight().setPapa(aux);
        aux.getRight().setLeft(temp);
        
  

        if(aux.getPapa()==null) {
            this.root = aux;
        }
    

    }

    private void rightRight(BinaryNode<T> aux) {
        BinaryNode<T> temp = aux.getLeft();

        aux.setLeft(aux.getPapa());            
        aux.setPapa(aux.getPapa().getPapa());
        aux.getLeft().setPapa(aux);
        aux.getLeft().setRight(temp);
        
  

        if(aux.getPapa()==null) {
            this.root = aux;
        }

    }

    private void rightLeft(BinaryNode<T> aux) {

        BinaryNode<T> temp = aux.getLeft();

        aux.setLeft(temp.getRight());
        if(temp.getRight()!=null) {         
            temp.getRight().setPapa(aux);
        }

        aux.getPapa().setRight(temp.getLeft());
        if(temp.getLeft()!=null) {         
            temp.getLeft().setPapa(aux.getPapa());
        }

        temp.setLeft(aux.getPapa());
        temp.setPapa(aux.getPapa().getPapa());
        aux.getPapa().setPapa(temp);
        

        temp.setRight(aux);
        aux.setPapa(temp);

        if(temp.getPapa()==null) {           
            this.root = temp;
        }

    }

    private int leftRight(BinaryNode<T> aux) {
        int res = 0;
        BinaryNode<T> temp = aux.getRight();

        aux.setRight(temp.getLeft());
        if(temp.getLeft()!=null) {         
            temp.getLeft().setPapa(aux);
        }

        aux.getPapa().setLeft(temp.getRight());
        if(temp.getRight()!=null) {
            
            temp.getRight().setPapa(aux.getPapa());
        }

        temp.setRight(aux.getPapa());
        temp.setPapa(aux.getPapa().getPapa());
        aux.getPapa().setPapa(temp);
        

        temp.setLeft(aux);
        aux.setPapa(temp);

        if(temp.getPapa()==null) {
            res=1;
            this.root = temp;
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

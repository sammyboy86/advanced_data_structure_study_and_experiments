import java.util.ArrayList;

import javax.xml.transform.TransformerConfigurationException;

public class AVLTree<T extends Comparable<T>> {
    BinaryNode<T> root;

    AVLTree(BinaryNode<T> root) {
        this.root = root;
        
    }

    public int insert(BinaryNode<T> node) {
        int res = 0;
        BinaryNode<T> aux = root;

        boolean bandera = true;
        while(bandera&&aux!=null) {
            int comparison = aux.getKey().compareTo(node.getKey());

            if(comparison>=0&&aux.getLeft()!=null) {

                aux = aux.getLeft();
                
            } else if(aux.getRight()!=null) {

                aux = aux.getRight();

            } else {

                bandera = false;
            }

        }

        if(aux==null) {
            this.root = node;

        } else {           

            if(aux.getKey().compareTo(node.getKey())>=0) {

                aux.setLeft(node);

            } else {

                aux.setRight(node);

            }

            node.setPapa(aux);

            aux = node;
            bandera = false;

            while(aux!=null&&!bandera) {
                if(Math.abs(aux.getBalanceFactor())>=2) {

                    bandera = true;
                } else {
                    aux=aux.getPapa();
                }
                
            }

            if(bandera) {
                if(aux.getBalanceFactor()>=2) {
                    
                    if(aux.getRight().getKey().compareTo(node.getKey())<0) {
                        
                        rightRight(aux);

                    } else {
                        rightLeft(aux);
                    }
                } else {

                    if(aux.getLeft().getKey().compareTo(node.getKey())>=0) {
                        res = (int)aux.getKey();
                        
                        leftLeft(aux);

                    } else {
                        leftRight(aux);
                    }

                }

            }

        }
        return res;


    }

    private void rightRight(BinaryNode<T> tempRoot) {
        BinaryNode<T> tempRootRight = tempRoot.getRight();

        tempRoot.setRight(tempRootRight.getLeft());
        tempRootRight.setPapa(tempRoot.getPapa());

        if(tempRoot.getRight()!=null) {
            tempRoot.getRight().setPapa(tempRoot);

        }

        tempRootRight.setLeft(tempRoot);
        tempRoot.setPapa(tempRootRight);

        if(tempRoot.equals(root)) {
            this.root = tempRootRight;
        }

        if(tempRoot.getPapa().getKey().compareTo(tempRoot.getKey()) > 0) {
            tempRoot.getPapa().setLeft(tempRootRight);
        } else {
            tempRoot.getPapa().setRight(tempRootRight);
        }

    }

    private void rightLeft(BinaryNode<T> tempRoot) {
        BinaryNode<T> tempRootRight = tempRoot.getRight();
        BinaryNode<T> tempRootRightLeft = tempRoot.getRight().getLeft();

        tempRoot.setRight(tempRootRightLeft.getLeft());
        tempRootRight.setLeft(tempRootRightLeft.getRight());
        

        if(tempRoot.getRight()!=null) {
            tempRoot.getRight().setPapa(tempRoot);
        }

        if(tempRootRight.getLeft()!=null) {
            tempRootRight.getLeft().setPapa(tempRootRight);
        }

        tempRootRightLeft.setPapa(tempRoot.getPapa());
        tempRootRightLeft.setLeft(tempRoot);
        tempRootRightLeft.setRight(tempRootRight);
        tempRoot.setPapa(tempRootRightLeft);
        tempRootRight.setPapa(tempRootRightLeft);

        if(tempRoot.equals(root)) {
            this.root = tempRootRightLeft;
        }

        if(tempRoot.getPapa().getKey().compareTo(tempRoot.getKey()) > 0) {
            tempRoot.getPapa().setLeft(tempRootRightLeft);
        } else {
            tempRoot.getPapa().setRight(tempRootRightLeft);
        }

    }

    private void leftLeft(BinaryNode<T> tempRoot) {
        BinaryNode<T> tempRootLeft = tempRoot.getLeft();

        tempRoot.setLeft(tempRootLeft.getRight());
        tempRootLeft.setPapa(tempRoot.getPapa());

        if(tempRoot.getLeft()!=null) {
            tempRoot.getLeft().setPapa(tempRoot);

        }

        tempRootLeft.setRight(tempRoot);
        tempRoot.setPapa(tempRootLeft);

        if(tempRoot.equals(root)) {
            this.root = tempRootLeft;
        }

        if(tempRoot.getPapa().getKey().compareTo(tempRoot.getKey()) > 0) {
            tempRoot.getPapa().setLeft(tempRootLeft);
        } else {
            tempRoot.getPapa().setRight(tempRootLeft);
        }

    }

    private void leftRight(BinaryNode<T> tempRoot) {
        BinaryNode<T> tempRootLeft = tempRoot.getLeft();
        BinaryNode<T> tempRootLeftRight = tempRoot.getLeft().getRight();

        tempRoot.setLeft(tempRootLeftRight.getRight());
        tempRootLeft.setRight(tempRootLeftRight.getLeft());
        

        if(tempRoot.getLeft()!=null) {
            tempRoot.getLeft().setPapa(tempRoot);
        }

        if(tempRootLeft.getRight()!=null) {
            tempRootLeft.getRight().setPapa(tempRootLeft);
        }

        tempRootLeftRight.setPapa(tempRoot.getPapa());
        tempRootLeftRight.setRight(tempRoot);
        tempRootLeftRight.setLeft(tempRootLeft);
        tempRoot.setPapa(tempRootLeftRight);
        tempRootLeft.setPapa(tempRootLeftRight);

        if(tempRoot.equals(root)) {
            this.root = tempRootLeftRight;
        }

        if(tempRoot.getPapa().getKey().compareTo(tempRoot.getKey()) > 0) {
            tempRoot.getPapa().setLeft(tempRootLeftRight);
        } else {
            tempRoot.getPapa().setRight(tempRootLeftRight);
        }

    }

    public String toString() {
        ArrayList<BinaryNode<T>> nodes = new ArrayList<BinaryNode<T>>();
        StringBuilder string = new StringBuilder();
        nodes.add(root);

        if(root!=null) {
            string.append(root.getKey().toString());
        }
        

        while(!nodes.isEmpty()) {
            ArrayList<BinaryNode<T>> aux = new ArrayList<BinaryNode<T>>();
            string.append("\n");
            
            for(int i = 0; i<nodes.size(); i++) {
                BinaryNode<T> node = nodes.get(i);
                BinaryNode<T> left = node.getLeft();
                BinaryNode<T> right = node.getRight();
                if(left!=null) {
                    string.append(left.getKey().toString()).append(" ");
                    aux.add(left);

                }

                if (right!=null) {
                    string.append(right.getKey().toString()).append(" ");
                    aux.add(right);

                }

            
            }
            
            nodes = aux;


        }

        return(string.toString());
        
    }
    
}

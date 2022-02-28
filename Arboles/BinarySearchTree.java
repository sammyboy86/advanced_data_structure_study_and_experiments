public class BinarySearchTree<T extends Comparable<T>> implements BinaryTreeADT<T> {

    private NodoBB<T> raiz;
    private int card;

    BinarySearchTree() {
        raiz = null;
        card = 0;

    }
    
    BinarySearchTree(NodoBB<T> raiz) {
        this.raiz = raiz;
        card = 1;

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(T elem) {
        // TODO Auto-generated method stub
        return false;
    }

    public NodoBB<T> buscar(T elem) {
        return buscar(elem, raiz);
    }

    private NodoBB<T> buscar(T elem, NodoBB<T> actual) {
        if(actual==null) {
            return null;
        } else if(actual.getElem().compareTo(elem)==0) {
            return actual;
        } else {
            if(actual.getElem().compareTo(elem)<0) {
                return buscar(elem, actual.getDer());
            } else {
                return buscar(elem, actual.getIzq());
            }
        }
    }

    public NodoBB<T> eliminar(T elem) {
        NodoBB<T> nodo = buscar(elem);
        if(nodo==null) {
            return null;
        } else {
            if(nodo.getDer()==null&&nodo.getIzq()==null) {
                if(nodo.getPapa().getElem().compareTo(elem)<0) {
                    nodo.getPapa().setDer(null);
                } else {
                    nodo.getPapa().setIzq(null);

                }
  
            } else {
                NodoBB<T> aux = nodo.getDer();
                while(aux.getIzq()!=null) {
                    aux = aux.getIzq();
                }

                
            }
            

        }
        return nodo;



    }
    
}

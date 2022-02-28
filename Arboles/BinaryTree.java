import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<T> implements BinaryTreeADT<T>{

    private NodoBin<T> raiz;
    int cont;

    public BinaryTree(NodoBin<T> raiz) {
        this.raiz = raiz;
        cont++;
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

    public String recorrePreorden() {
        StringBuilder res = new StringBuilder();
        res.append(recorrePreorden(raiz).toString());       
        return res.toString();

    }

    private NodoBin<T> recorrePreorden(NodoBin<T> actual) {
        if(actual.getIzq()==null&&actual.getDer()==null) {
            return null;

        } else {
            
            if(actual.getIzq()!=null) {            
                recorrePreorden(actual.getIzq());    
                return actual.getIzq();
                
            } else {
                recorrePreorden(actual.getDer());    
                return actual.getDer();
            }


        }

    }

    public Iterator<T> iteradorPreorden() {
        ArrayList<T> lista = new ArrayList<T>();
        preorden(raiz, lista);
        return lista.iterator();

    }

    private void preorden(NodoBin<T> actual, ArrayList<T> lista) {
        if(actual==null) {

        } else {

            lista.add(actual.getElem());
            preorden(actual.getIzq(), lista);
            preorden(actual.getDer(), lista);

        }         
    }

    private void preOrdenIterativo(ArrayList<T> lista) {
        Stack<NodoBin<T>> pila = new Stack<NodoBin<T>>();
        pila.add(raiz);

        while(!pila.isEmpty()) {
            NodoBin<T> actual = pila.pop();
            
            lista.add(actual.getElem());

            if(actual.getDer()!=null) {
                pila.add(actual.getDer());
            }
            if(actual.getIzq()!=null) {
                pila.add(actual.getIzq());
            }

        }


    }
    
    public Iterator<T> nivelIterativo() {
        ArrayList<T> lista = new ArrayList<T>();
        ArrayList<NodoBin<T>> cola = new ArrayList<NodoBin<T>>();
        cola.add(raiz);

        while(!cola.isEmpty()) {
            NodoBin<T> actual = cola.remove(0);
            
            lista.add(actual.getElem());

            if(actual.getDer()!=null) {
                cola.add(actual.getDer());
            }
            if(actual.getIzq()!=null) {
                cola.add(actual.getIzq());
            }

        }

        return lista.iterator();


    }

    public boolean contiene(T elemento) {
        return buscaElem(raiz, elemento);

    }

    //falta acabar esto
    private boolean buscaElem(NodoBin<T> actual, T elemento) {
        if(actual==null) {

        }

        if(actual.getElem().equals(elemento)) {
            return true;

        } else {
            if(buscaElem(actual.getIzq(), elemento)) {
                return true;
            } else {
                buscaElem(actual.getDer(), elemento);
            }
            return false;

        }

    }

    public int altura() {
        return altura(raiz,0);
    }

    private int altura(NodoBin<T> nodo, int cont) {
        if(nodo==null) {
            return cont;
        } else {
            return Math.max(altura(nodo.getDer(), ++cont), altura(nodo.getIzq(), ++cont));

        }

    }

        
    }







    


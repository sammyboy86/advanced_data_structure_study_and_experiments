public class NodoBB<T extends Comparable<T>> {
    T elem;
    NodoBB<T> izq, der, papa;

    NodoBB() {

    }

    NodoBB(T dato, NodoBB<T> papa) {
        this.papa = papa;
        elem = dato;
        izq = null;
        der = null;
    }

    public void setIzq(NodoBB<T> izquierdo) {
        izq.setPapa(this);
        this.izq = izquierdo;

    }

    public void setDer(NodoBB<T> derecho) {
        der.setPapa(papa);
        this.der = derecho;

    }


    public NodoBB<T> getIzq() {
        return izq;

    }

    public NodoBB<T> getDer() {
        return der;

    }

    public NodoBB<T> getPapa() {
        return papa;

    }

    public void setPapa(NodoBB<T> papa) {
        this.papa = papa;
    }

    public T getElem() {
        return elem;

    }

    public String toString() {
        return elem.toString();
    }

    public int numDescendientes() {

        int res = 0;

        if(this.getDer()!= null) {
            res=  1 + getDer().numDescendientes();
        }

        if(this.getIzq()!= null) {
            res= 1 + getIzq().numDescendientes();

        }

        return res;
        
    }
    
}

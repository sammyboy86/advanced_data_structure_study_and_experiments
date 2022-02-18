public class NodoBin<T> {
    T elem;
    NodoBin<T> izq, der;

    NodoBin() {

    }

    NodoBin(T dato) {
        elem = dato;
        izq = null;
        der = null;
    }

    public void setIzq(NodoBin<T> izquierdo) {
        this.izq = izquierdo;

    }

    public void setDer(NodoBin<T> derecho) {
        this.der = derecho;

    }


    public NodoBin<T> getIzq() {
        return izq;

    }

    public NodoBin<T> getDer() {
        return der;

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

    /*

    private int contarDescendientes(NodoBin<T> actual, int i) {
        if(actual.getDer()==null&&actual.getIzq()==null) {
            return i;

        } else { 
            if(actual.getDer()==null) {
                contarDescendientes(actual.getIzq(), ++i);

            } else if(actual.getIzq()==null) {
                contarDescendientes(actual.getDer(), ++i);

            } else {
                contarDescendientes(actual.getIzq(), ++i);
                contarDescendientes(actual.getDer(), i);
            }
                    
        }
        

    } */


    
}

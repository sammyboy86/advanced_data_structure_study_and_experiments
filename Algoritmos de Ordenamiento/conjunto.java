public class conjunto<T> {

    private int cardinalidad;
    private T[] elementos;
    
    conjunto() {
        cardinalidad = 0;
    }

    conjunto(T elem) {
        cardinalidad = 1;
        elementos[0] = elem;
    }

    public void alta(T elem) {
        if(cardinalidad==elementos.length) {
           // T[] temp = new T[cardinalidad*2];

        }
    }

    public int getCardinalidad() {
        return cardinalidad;
    }
    
}

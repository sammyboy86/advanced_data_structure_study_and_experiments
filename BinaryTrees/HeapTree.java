import java.lang.StringBuilder;

public class HeapTree<T extends Comparable<T>>{
    T datos[];
    int cont;
    
    public HeapTree(){
      datos=(T[])new Comparable[2];
      cont=0;
    }
    
    public T buscaMin(){
      if (cont==0)
        return null;
      return datos[1];
    }
  
    private void expandeDatos() {
          T[] temp = (T[])new Comparable[cont*2];
          for(int i = 1; i<datos.length; i++) {
              temp[i] = datos[i];
          }
  
          datos = temp;
  
      }
  
    public void insert(T element){
  
        if (cont+1>=datos.length)//expandir tamaño
          expandeDatos();
          
      
        cont+=1;
        datos[cont] = element;
        //Revisa que esté en la posición correcta
        int aux = cont;
        int dad = aux;
        while(aux > 1 && datos[aux].compareTo(datos[aux>>1]) < 0){
            dad = aux >> 1;
            //Cambiamos las posiciones
            T change = datos[dad];
            datos[dad] = datos[aux];
            datos[aux] = change;
            aux = dad;
        }
        cont++;
      }

      public String toString() {
          StringBuilder string = new StringBuilder();
          for(int i = 1; i<datos.length; i++) {
              string.append(datos[i]).append(", ");
          }

          return(string.toString());



      }
}
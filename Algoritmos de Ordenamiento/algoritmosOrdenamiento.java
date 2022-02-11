public class algoritmosOrdenamiento {

    /**
     * @param args the command line arguments
     */
    
    //seleccion directa
    
    public static String imprimirArreglo(int[] arreglo) {
        String res ="";
        for(int i = 0; i<arreglo.length; i++) {
            res = res + arreglo[i];
        }
        return res;
    }
    
    
    public static void seleccionDirecta(int[] arreglo) {        
        int temp;
        for(int i = 0; i<arreglo.length; i++) {            
            for(int j = i; j<arreglo.length; j++) {
                if(arreglo[j]<arreglo[i]) {
                    temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }               
    }
    
    public static void insercionDirecta(int[] arreglo) {
        int actual, ind, temp;
        for(int i = 1; i<arreglo.length; i++) {
            
            ind = i;
            actual = arreglo[ind];

            while(ind!=0&&actual<arreglo[ind-1]) {
                temp = arreglo[ind-1];
                arreglo[ind-1] = actual;
                arreglo[ind] = temp;
                
                ind = ind-1;
                
                
            }
            
        }
    }

    //no lo terminaste!
    public static void bubbleSort(int[] arreglo) {
        int actual, comp;
        for(int i = 0; i<arreglo.length; i++) {
            actual = arreglo[0];
            for(int j = 1; j<arreglo.length-i; j++) {
                comp = arreglo[j];
                if(actual>comp) {
                    

                }

            }
        }
    }

 

    public static void quickSort(int[] arreglo, int min, int max) {
        if(arreglo.length==1) {

        } else {
            
           
            }
            



        
        
    }

      
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        

        int[] nums = {3,2,1, 5, 0, -9};
        insercionDirecta(nums);
        System.out.println(imprimirArreglo(nums));
        

       ;
    }
    
}

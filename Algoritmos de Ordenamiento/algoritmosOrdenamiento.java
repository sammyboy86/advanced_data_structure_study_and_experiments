import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class algoritmosOrdenamiento {

    /**
     * @param args the command line arguments
     */
    
    //seleccion directa
    
    public static<T> String imprimirArreglo(T[] arreglo) {
        String res ="";
        for(int i = 0; i<arreglo.length; i++) {
            res = res + arreglo[i] + ", ";
        }
        return res;
    }

    public static<T> void swap(T[] arreglo, int ind1, int ind2) {
        T temp = arreglo[ind1];
        arreglo[ind1] = arreglo[ind2];
        arreglo[ind2] = temp;
    }
    
    
    public static <T extends Comparable<T>> void seleccionDirecta(T[] arreglo) {        
        T temp;
        for(int i = 0; i<arreglo.length; i++) {            
            for(int j = i; j<arreglo.length; j++) {
                if(arreglo[j].compareTo(arreglo[i])<0) {
                    temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }               
    }


    
    public static <T extends Comparable<T>> void insercionDirecta(T[] arreglo) {
        T actual,  temp;
        int ind;
        for(int i = 1; i<arreglo.length; i++) {
            
            ind = i;
            actual = arreglo[ind];

            while(ind!=0&&actual.compareTo(arreglo[ind-1])<0) {
                temp = arreglo[ind-1];
                arreglo[ind-1] = actual;
                arreglo[ind] = temp;
                
                ind = ind-1;
                
                
            }
            
        }
    }


    public static <T extends Comparable<T>> void bubbleSort(T[] arreglo) {
        for(int i = 0; i<arreglo.length; i++) {
            for(int j = 0; j<arreglo.length-i-1; j++) {
                if(arreglo[j].compareTo(arreglo[j+1])>0) {
                    swap(arreglo, j, j+1);
                }
            }
        }
        
        
    }

 

    public static <T extends Comparable<T>> void quickSort(T[] arreglo, int min, int max) {
        if(min>=max) {

        } else {
            int pivote = reubicaPivote(arreglo, min, max);
            quickSort(arreglo, min, pivote-1);
            quickSort(arreglo, pivote+1, max);

        }   
    }

    public static <T extends Comparable<T>> int reubicaPivote(T[] arreglo,  int min, int max) {
        T pivote = arreglo[min];
        int ubiPivote = min;
        min++;

        while(min<=max) {           
            if(arreglo[min].compareTo(pivote)>0) {
                swap(arreglo, max, min);
                max--;
            
            } else {
                min++;

            }
        } 
        //aa

        swap(arreglo, min-1, ubiPivote);
        return(min-1);

        }

    public static <T extends Comparable<T>> void mergeSort(T[] arreglo, int l, int r) {
        if(l<r) {
            int m = (r+l)/2;
            mergeSort(arreglo, l, m);
            mergeSort(arreglo, m+1, r);

            merge(arreglo, l, m, r);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        ArrayList<T> temp1 = new ArrayList<>();
        ArrayList<T> temp2 = new ArrayList<>();
 
        for (int i=0; i<n1; ++i)
            temp1.add(arr[l + i]);
        for (int j=0; j<n2; ++j)
            temp2.add(arr[m + 1+ j]);
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2)
        {
            if (temp1.get(i).compareTo(temp2.get(j))<= 0)
            {
                arr[k] = temp1.get(i);
                i++;
            }
            else
            {
                arr[k] = temp2.get(j);
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = temp1.get(i);
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = temp2.get(j);
            j++;
            k++;
        }
    }


    
    public static <T extends Comparable<T>> void main(String[] args) throws IOException {
        // TODO code application logic here
        /*

        Integer[] nums = {-3,0,1, -3, -2, -1, 30, 30 , -4, 0, 0};
        Integer[] nums2 = {0,1,-3, 56, -6, 420, 30, 30 , -4, 0, 0};
        //quickSort(nums, 0, nums.length-1);
        //quickSort(nums2, 0, nums.length-1);
        mergeSort(nums, 0, nums.length-1);

        System.out.println(imprimirArreglo(nums));       */

        // open file input stream
		BufferedReader reader = new BufferedReader(new FileReader("movie_titles2.txt"));
        
        String line = null;
        Scanner scanner = null;
        int index = 0;

        ArrayList<Peli> pelisMadre = new ArrayList<Peli>();
        
        while((line = reader.readLine()) != null) {
            Peli peli = new Peli();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            
            peli.setId(Integer.parseInt(scanner.next()));
            peli.setAnio(Integer.parseInt(scanner.next()));
            peli.setTitulo(scanner.next());

            pelisMadre.add(peli);
        } 

        reader.close();

        Peli[] pelisOrdenadas = new Peli[17770*2];

        for(int i = 0; i<17770; i++) {
            pelisOrdenadas[i] = pelisMadre.get(i);
        }

        for(int i = 0; i<17770; i++) {
            pelisOrdenadas[i+17770] = pelisMadre.get(i);
        }

        //mergeSort(pelisOrdenadas, 0, 35000);

        //Collections.reverse(Arrays.asList(pelisOrdenadas));




        long start = System.currentTimeMillis();

        seleccionDirecta(Arrays.copyOfRange(pelisOrdenadas, 0, 35000));

        System.out.println(System.currentTimeMillis() - start);
        long start2 = System.currentTimeMillis();

        insercionDirecta(Arrays.copyOfRange(pelisOrdenadas, 0, 35000));

        System.out.println(System.currentTimeMillis() - start2);
        long start3 = System.currentTimeMillis();

        bubbleSort(Arrays.copyOfRange(pelisOrdenadas, 0, 35000));
        
        System.out.println(System.currentTimeMillis() - start3);
        long start4 = System.currentTimeMillis();

        
        quickSort(Arrays.copyOfRange(pelisOrdenadas, 0, 35000),0, 35000-1);

        System.out.println(System.currentTimeMillis() - start4);
        long start5 = System.currentTimeMillis();

        mergeSort(Arrays.copyOfRange(pelisOrdenadas, 0, 35000), 0, 35000-1);

        System.out.println(System.currentTimeMillis() - start5);
        long start6 = System.currentTimeMillis();

      
    }


    
}

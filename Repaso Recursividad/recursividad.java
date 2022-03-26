import java.util.ArrayList;

public class recursividad<T> {

    public String imprimeRevesRecursivo(ArrayList<T> arreglo) {
        return imprimeRevesRecursivoPriv(0, arreglo, "");

    }

    private String imprimeRevesRecursivoPriv(int ubi, ArrayList<T> arreglo, String cad) {
        if(ubi>=arreglo.size()) {

            return("");

        } else {
            imprimeRevesRecursivoPriv(ubi+1, arreglo, cad);

            return(cad + arreglo.get(ubi).toString());

        }

    }

    public static void main(String[] args) { 



    }




    
}

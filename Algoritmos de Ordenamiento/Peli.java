public class Peli implements Comparable<Peli> {

    private int id, anio;
    private String titulo;

    public Peli() {

    }

    public Peli(int id, int anio, String titulo) {
        this.id = id;
        this.anio = anio;
        this.titulo = titulo;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void setAnio(int id) {
        this.anio = id;

    }
    public void setTitulo(String id) {
        this.titulo = id;

    }

    public String toString() {

        return(""+ id +" "+ anio + " " + titulo);

    }

    @Override
    public int compareTo(Peli o) {
        if(this.id<o.getId()) {
            return -1;

        } else if(this.id>o.getId()) {
            return 1;

        } else {
            return 0;

        }
 
    
    }
    
}

public class Peli {

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
    
}

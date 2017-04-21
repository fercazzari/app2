package pp2.app2.modelo;

public class Categoria {

    private int id;
    private String nombre;

    Categoria() {
        this.id = 0;
        this.nombre = "";
    }

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return this.id + " " + this.nombre;
    }

}

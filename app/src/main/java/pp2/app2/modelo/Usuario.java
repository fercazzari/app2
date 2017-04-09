package pp2.app2.modelo;

/**
 * Created by fcazzari on 09/04/2017.
 */

public class Usuario {

    private int id;
    private String nombre;

    Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.nombre;
    }

}

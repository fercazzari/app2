package pp2.app2.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Producto {

    @SerializedName("idProducto")
    @Expose
    private Integer idProducto;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("idCategoria")
    @Expose
    private Integer idCategoria;

    public Producto() {
        this.idProducto = 0;
        this.nombre = "";
        this.idCategoria = 0;
    }

    public Producto (int id, String nombre, int idCategoria) {
        this.idProducto = id;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return idProducto;
    }

    public void setId(int id) {
        this.idProducto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return this.idProducto + " " + this.nombre + " " + this.getIdCategoria();
    }
}


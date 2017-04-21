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

    public String getNombre() {
        return nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    @Override
    public String toString() {
        return this.idProducto + " " + this.nombre + " " + this.getIdCategoria();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (idCategoria != other.idCategoria)
            return false;
        if (idProducto != other.idProducto)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }
}


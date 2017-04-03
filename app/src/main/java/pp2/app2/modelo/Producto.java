package pp2.app2.modelo;

import android.graphics.drawable.Drawable;

/**
 * Created by fcazzari on 25/03/2017.
 */

public class Producto {

    private int id;
    private String descripcion;
    private Drawable imagen;
    private Categoria categoria;

    public Producto() {

    }

    public Producto( int id, String descripcion, Drawable imagen, Categoria categoria) {

        this.id = id;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.categoria = categoria;

    }

    public int getId () {
        return this.id;
    }

    public String getDescripcion () {
        return this.descripcion;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producto producto = (Producto) o;
        return id == producto.id &&
                descripcion.equals(producto.descripcion) &&
                categoria == producto.categoria;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
}


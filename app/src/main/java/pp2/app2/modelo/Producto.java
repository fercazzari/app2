package pp2.app2.modelo;

import pp2.app2.helpers.IdentityField;

public class Producto {

    private IdentityField id;
    private String nombre;

    public Producto () {
        this.id = new IdentityField(0);
        this.nombre = "";
    }

    public Producto (IdentityField id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public IdentityField getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
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
        if (id.getField() != other.id.getField())
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }
}


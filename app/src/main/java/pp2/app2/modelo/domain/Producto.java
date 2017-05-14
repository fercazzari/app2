package pp2.app2.modelo.domain;

public class Producto {

    private IdentityField id;
    private String nombre;
    private double precio;

    public Producto () {
        this.id = new IdentityField(0);
        this.nombre = "";
        this.precio = 0.0;
    }

    public Producto (IdentityField id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public IdentityField getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio () { return this.precio; }

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
        } else if (!nombre.equals(other.nombre)) {
            return false;
        } else if (precio != other.precio)
            return false;
        return true;
    }
}


package pp2.app2.modelo.domain;

public class Producto {

    private int id; // identity field
    private String nombre;
    private double precio;

    public Producto () {
        this.id = 0;
        this.nombre = "";
        this.precio = 0.0;
    }

    public Producto (int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
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
        if (id!= other.id)
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


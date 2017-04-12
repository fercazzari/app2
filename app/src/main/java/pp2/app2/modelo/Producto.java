package pp2.app2.modelo;

import pp2.app2.helpers.UnitOfWork;

public class Producto implements Item {

    private int id;
    private String nombre;
    private int idCategoria;

    public Producto() {
        this.id = 0;
        this.nombre = "";
        this.idCategoria = 0;
    }

    public Producto (int id, String nombre, int idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        markDirty();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        markDirty();
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
        markDirty();
    }

    @Override
    public String toString() {
        return this.id + " " + this.nombre + " " + this.getIdCategoria();
    }

    public void markNew () {
        UnitOfWork.getCurrent().registrarNew(this);
    }

    protected void markClean () {
        UnitOfWork.getCurrent().registrarClean(this);
    }

    protected void markDirty () {
        UnitOfWork.getCurrent().registrarDirty(this);
    }

    protected void markRemoved () {
        UnitOfWork.getCurrent().registrarRemoved(this);
    }
}


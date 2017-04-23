package pp2.app2.helpers;

import java.util.LinkedList;
import java.util.List;

import pp2.app2.modelo.Producto;

/**
 * Created by fcazzari on 19/04/2017.
 */

public class CarritoUOW implements UnitOfWork {

    private List<Producto> nuevos;
    private List<Producto> modificados;
    private List<Producto> eliminados;

    public CarritoUOW() {
        this.nuevos = new LinkedList<Producto>();
        this.modificados = new LinkedList<Producto>();
        this.eliminados = new LinkedList<Producto>();
    }

    @Override
    public void registrarNew(Object o)
    {
        //eliminados.contains(o) ? eliminados.remove(o) : nuevos.add((Producto) o);
        if (this.eliminados.contains(o))
        {
            this.eliminados.remove(o);
        }
        else
        {
            this.nuevos.add((Producto) o);
        }
    }

    @Override
    public void registrarDirty(Object o)
    {
        this.modificados.add((Producto) o);
    }

    @Override
    public void registrarRemoved(Object o)
    {
        //nuevos.contains(o) ? nuevos.remove(o) : eliminados.add((Producto) o);
        if (this.nuevos.contains(o))
        {
            this.nuevos.remove(o);
        }
        else
        {
            this.eliminados.add((Producto) o);
        }
    }

    @Override
    public boolean commit() {
        return true;
    }

    @Override
    public boolean rollback() {
        return false;
    }

    @Override
    public boolean clear() {
        this.nuevos.clear();
        this.modificados.clear();
        this.eliminados.clear();
        return true;
    }

    public boolean isEmpty () {
        return this.nuevos.isEmpty() && this.modificados.isEmpty()  && this.eliminados.isEmpty();
    }

    public List<Producto> getNuevos () {
        return this.nuevos;
    }

    public List<Producto> getModificados () {
        return this.nuevos;
    }

    public List<Producto> getEliminados () {
        return this.nuevos;
    }
}
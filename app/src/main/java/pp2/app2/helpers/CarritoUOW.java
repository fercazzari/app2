package pp2.app2.helpers;

import java.util.HashSet;
import java.util.Set;
import pp2.app2.modelo.Producto;

/**
 * Created by fcazzari on 19/04/2017.
 */

public class CarritoUOW implements UnitOfWork {

    private Set<Producto> nuevos;
    private Set<Producto> modificados;
    private Set<Producto> eliminados;

    public CarritoUOW() {
        this.nuevos = new HashSet<Producto>();
        this.modificados = new HashSet<Producto>();
        this.eliminados = new HashSet<Producto>();
    }

    @Override
    public void registrarNew(Object o) {
        this.nuevos.add((Producto) o);
    }

    @Override
    public void registrarDirty(Object o) {
        this.modificados.add((Producto) o);
    }

    @Override
    public void registrarRemoved(Object o) {
        this.eliminados.add((Producto) o);
    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void clear() {
        this.nuevos.clear();
        this.modificados.clear();
        this.eliminados.clear();
    }

    public boolean isEmpty () {
        return this.nuevos.isEmpty() && this.modificados.isEmpty()  && this.eliminados.isEmpty();
    }
}

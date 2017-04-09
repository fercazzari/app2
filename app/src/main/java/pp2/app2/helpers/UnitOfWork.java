package pp2.app2.helpers;

import java.util.Iterator;
import java.util.List;

import pp2.app2.modelo.Producto;

/**
 * Created by fcazzari on 09/04/2017.
 */

public class UnitOfWork {

    /*
     UNIT OF WORK
     Maintains a list of objects affected by a business transaction and coordinates the writing out
     of changes and the resolution of concurrency problems.

     When you're pulling data in and out of a database, it's important to keep track of what you've
     changed; otherwise, that data won't be written back into the database. Similarly you have to
     insert new objects you create and remove any objects you delete.
     */

    private List<Producto> new_objects;
    private List<Producto> dirty_objects;
    private List<Producto> removed_objects;

    UnitOfWork() {
    }

    UnitOfWork(List<Producto> new_objects, List<Producto> dirty_objects, List<Producto> removed_objects) {
        this.new_objects = new_objects;
        this.dirty_objects = dirty_objects;
        this.removed_objects = removed_objects;
    }

    public void registrarNew (Producto producto) {

    }

    public void registrarDirty (Producto producto) {

    }

    public void registrarRemoved (Producto producto) {

    }

    public void registrarClean (Producto producto) {

    }

    public void commit () {
        insertNew();
        updateDirty();
        deleteRemoved();
    }

    private void insertNew () {
        for (Iterator objects = new_objects.iterator(); objects.hasNext();) {
            Producto producto = (Producto) objects.next();
            // MapperRegistry.getMapper(obj.getClass()).insert(obj);
        }
    }

    private void updateDirty () {

    }

    private void deleteRemoved () {

    }

    private static ThreadLocal current = new ThreadLocal();

    public static void newCurrent () {
        setCurrent (new UnitOfWork());
    }

    public static void setCurrent (UnitOfWork uow) {
        current.set(uow);
    }

    public static UnitOfWork getCurrent() {
        return (UnitOfWork) current.get();
    }

}

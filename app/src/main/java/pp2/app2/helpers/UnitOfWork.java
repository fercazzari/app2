package pp2.app2.helpers;

public interface UnitOfWork {

    public void registrarNew (Object o);

    public void registrarDirty(Object o);

    public void registrarRemoved(Object o);

    public boolean commit();

    public boolean rollback();

    public boolean clear();

}

package pp2.app2.modelo.domain;

/**
 * Created by Jony on 14/05/2017.
 */

public class VerificadorDeStock
{
    public static boolean hayStock(Producto p)
    {
        //Conectarse y preguntar si hay stock de tal producto
        if (p.getNombre().equals("anana"))
            return false;
        return true;
    }
}

package pp2.app2.modelo;

/**
 * Created by Jony on 23/04/2017.
 */

public class DatosTemp
{
    private Carrito carritoTemp = new Carrito();

    public DatosTemp()
    {
        obtenerCarrito();
    }

    private void obtenerCarrito()
    {
        if (carritoTemp.getItems().isEmpty())
        {
            carritoTemp.agregarItem(new Producto(1, "Anana", 2));
            carritoTemp.agregarItem(new Producto(2, "Manzana", 2));
            carritoTemp.agregarItem(new Producto(3, "Naranja", 2));
            carritoTemp.agregarItem(new Producto(4, "Kiwi", 2));
        }
    }

    public Carrito getCarritoTemp()
    {
        return carritoTemp;
    }

}

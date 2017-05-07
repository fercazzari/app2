package pp2.app2.modelo;

import java.util.LinkedList;
import java.util.List;

import pp2.app2.helpers.IdentityField;

/**
 * Created by Jony on 23/04/2017.
 */

public class DatosTemp
{
    private Carrito carritoTemp = new Carrito();
    private List<Producto> productos;

    public DatosTemp() {
        armarCarrito();
        armarProductos();
    }

    private void armarCarrito()
    {
        if (carritoTemp.getItems().isEmpty())
        {
            carritoTemp.agregarItem(new Producto(new IdentityField(1), "Anana"));
            carritoTemp.agregarItem(new Producto(new IdentityField(2), "Manzana"));
            carritoTemp.agregarItem(new Producto(new IdentityField(3), "Naranja"));
            carritoTemp.agregarItem(new Producto(new IdentityField(4), "Kiwi"));
        }
    }

    public Carrito obtenerCarrito() {
        return carritoTemp;
    }

    public void armarProductos () {
        this.productos = new LinkedList<Producto>();
        this.productos.add(new Producto(new IdentityField(100), "anana"));
        this.productos.add(new Producto(new IdentityField(101), "kiwi"));
        this.productos.add(new Producto(new IdentityField(102), "arvejas"));
        this.productos.add(new Producto(new IdentityField(103), "naranja"));
        this.productos.add(new Producto(new IdentityField(104), "lechuga"));
        this.productos.add(new Producto(new IdentityField(105), "tomate"));
        this.productos.add(new Producto(new IdentityField(106), "durazno"));
    }

    public List<Producto> obtenerProductos() {
        return this.productos;
    }

    public Producto obtenerProducto (int id) {
        Producto resultado = new Producto();
        for (int i = 0; i < this.productos.size(); i++) {
            if (this.productos.get(i).getId().getField() == id)
                resultado = this.productos.get(i);
        }
        return resultado;
    }
}

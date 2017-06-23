package pp2.app2.modelo.app;

import java.util.LinkedList;
import java.util.List;

import pp2.app2.modelo.domain.Carrito;
import pp2.app2.modelo.domain.Producto;

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
        { // TODO camb
            carritoTemp.agregarItem(new Producto(1, "Anana", 10));
            carritoTemp.agregarItem(new Producto(2, "Manzana", 11));
            carritoTemp.agregarItem(new Producto(3, "Naranja", 12));
            carritoTemp.agregarItem(new Producto(4, "Kiwi", 13));
        }
    }

    public Carrito obtenerCarrito() {
        return carritoTemp;
    }

    public void armarProductos () {
        this.productos = new LinkedList<Producto>();
        this.productos.add(new Producto(100, "anana", 20));
        this.productos.add(new Producto(101, "kiwi", 10));
        this.productos.add(new Producto(102, "arvejas", 30));
        this.productos.add(new Producto(103, "naranja", 25));
        this.productos.add(new Producto(104, "lechuga", 30));
        this.productos.add(new Producto(105, "tomate", 40));
        this.productos.add(new Producto(106, "durazno", 60));
        this.productos.add(new Producto(107, "arroz", 50));
    }

    public List<Producto> obtenerProductos() {
        return this.productos;
    }

    public Producto obtenerProducto (int id) {
        Producto resultado = new Producto();
        for (int i = 0; i < this.productos.size(); i++) {
            if (this.productos.get(i).getId() == id)
                resultado = this.productos.get(i);
        }
        return resultado;
    }
}

package pp2.app2.controlador;

import android.content.res.Resources;
import android.os.Message;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pp2.app2.R;
import pp2.app2.helpers.ApiConnector;
import pp2.app2.modelo.Categoria;
import pp2.app2.modelo.Producto;

/**
 * Created by Jony on 25/03/2017.
 */

public class CatalogoController
{
    ApiConnector conexion = new ApiConnector();

    public CatalogoController()
    {

    }

    // mientras no tengamos db (o para sobrevivir el miercoles)
    public List<Producto> getCatalogo (Resources res) {

        List<Producto> productos = new LinkedList<Producto>();
        productos.add(new Producto(1, "Galletitas Rellenas OREO C/Baño Chocolate", res.getDrawable(R.drawable.oreos), Categoria.ALMACÉN));
        productos.add(new Producto(2, "Bombones BON O BON Leche", res.getDrawable(R.drawable.bonobon), Categoria.ALMACÉN));

        return productos;
    }

    // idem getCatalogo
    public Producto getProducto (List<Producto> productos, int id) {
        Producto producto = new Producto();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                producto = productos.get(i);
            }
        }
        return producto;
    }


    public void ActualizarVista()
    {
        ApiConnector conexion = new ApiConnector();
        conexion.abrirConexion();
    }

    private ArrayList<Categoria> listarCategorias(Categoria categoria)
    {
        ArrayList<Categoria> listadoCategorias = new ArrayList<Categoria>();
        return listadoCategorias;
    }

    private ArrayList<Producto> armarCatalogo(Categoria categoria, int pagina)
    {
        ArrayList<Producto> listadoProductos = new ArrayList<Producto>();
        return listadoProductos;
    }
}
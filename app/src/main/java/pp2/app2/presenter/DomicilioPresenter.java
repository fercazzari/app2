package pp2.app2.presenter;

import android.content.Context;
import android.content.Intent;

import pp2.app2.activities.CompraActivity;
import pp2.app2.activities.DomicilioActivity;
import pp2.app2.controlador.ApplicationController;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.Item;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by Jony on 14/05/2017.
 */

public class DomicilioPresenter {

    public void armarVista(Context contexto, SolicitudDeCompra solicitud) {
        //Aca tenes que mostrar la vista

        Intent i = new Intent(contexto, DomicilioActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // i.putExtra("domicilio", solicitud.getDomicilioEntrega().getDatos());
        i.putExtra("sc_domicilio", "Calle 123");

        for (Item item : solicitud.getItems()) {
            // y mandar cada uno de los productos de la solicitud? Crazy
        }

        i.putExtra("sc_producto_id", String.valueOf(solicitud.getItems().get(0).getProducto().getId().getField()));
        i.putExtra("sc_producto_nombre", solicitud.getItems().get(0).getProducto().getNombre());
        i.putExtra("sc_producto_precio", String.valueOf(solicitud.getItems().get(0).getProducto().getPrecio()));

        contexto.startActivity( i );
    }

}

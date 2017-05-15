package pp2.app2.presenter;

import android.content.Context;
import android.content.Intent;

import pp2.app2.activities.DomicilioActivity;
import pp2.app2.activities.PagoActivity;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by fcazzari on 14/05/2017.
 */

public class PagoPresenter {

    public void armarVista(Context contexto, SolicitudDeCompra solicitud) {

        Intent i = new Intent(contexto, PagoActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        i.putExtra("sc_producto_id", String.valueOf(solicitud.getItems().get(0).getProducto().getId().getField()));
        i.putExtra("sc_producto_nombre", solicitud.getItems().get(0).getProducto().getNombre());
        i.putExtra("sc_producto_precio", String.valueOf(solicitud.getItems().get(0).getProducto().getPrecio()));

        i.putExtra("sc_domicilio", solicitud.getDomicilioEntrega().getDatos());

        contexto.startActivity( i );

    }
}

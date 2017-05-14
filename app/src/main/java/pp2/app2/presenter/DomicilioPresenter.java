package pp2.app2.presenter;

import android.content.Context;
import android.content.Intent;

import pp2.app2.activities.CompraActivity;
import pp2.app2.activities.DomicilioActivity;
import pp2.app2.controlador.ApplicationController;
import pp2.app2.modelo.domain.Domicilio;
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
        i.putExtra("domicilio", "Calle 123");

        contexto.startActivity( i );
    }

}

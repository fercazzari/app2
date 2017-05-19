package pp2.app2.presenter;

import android.content.Context;
import android.content.Intent;

import pp2.app2.activities.CompraFinalizadaActivity;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by Jony on 14/05/2017.
 */

public class CompraFinalizadaPresenter {

    public void armarVista(Context contexto, SolicitudDeCompra solicitud) {

        Intent i = new Intent(contexto, CompraFinalizadaActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        contexto.startActivity( i );

    }

}

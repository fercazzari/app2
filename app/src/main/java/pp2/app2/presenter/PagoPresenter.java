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
        contexto.startActivity( i );

    }
}

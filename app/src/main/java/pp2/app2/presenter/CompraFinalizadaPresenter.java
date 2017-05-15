package pp2.app2.presenter;

import android.content.Context;
import android.content.Intent;

import pp2.app2.activities.CompraFinalizadaActivity;

/**
 * Created by Jony on 14/05/2017.
 */

public class CompraFinalizadaPresenter {

    public void armarVista (Context context) {

        Intent i = new Intent(context, CompraFinalizadaActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity( i );

    }

}

package pp2.app2.presenter;

import android.content.Context;
import android.content.Intent;

import pp2.app2.activities.ProductoActivity;
import pp2.app2.modelo.domain.Producto;

/**
 * Created by Jony on 14/05/2017.
 */

public class ProductoPresenter {

    public static void armarVista(Context contexto, Producto producto) {

        Intent i = new Intent(contexto, ProductoActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        contexto.startActivity( i );

    }

    public static void armarVista(Context contexto, Producto producto, String mensajeError) {

        Intent i = new Intent(contexto, ProductoActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("sc_mensaje_error", mensajeError);
        contexto.startActivity( i );

    }

}

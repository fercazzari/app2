package pp2.app2.controlador;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pp2.app2.R;
import pp2.app2.activities.CompraActivity;
import pp2.app2.activities.ProductoActivity;
import pp2.app2.activities.RecomendacionActivity;
import pp2.app2.helpers.Constantes;
import pp2.app2.modelo.Producto;

import static pp2.app2.R.id.button_comprar;

/**
 * Created by fcazzari on 05/05/2017.
 */

public class ApplicationController {

    /*
    Place all the flow logic in an Application Controller.
    Input controllers then ask the Application Controller for the appropriate commands for
    execution against a model and the correct view to use depending on the application context.
     */

    // getDomainCommand(context)
    // getView(context)

    public static void onRequestMenuComprar (Context context) {
        Intent intent = new Intent(context, ProductoActivity.class);
        context.startActivity(intent);
    }

    public static void onRequestComprar (Context context, Producto producto) {

        Intent intent = new Intent(context, CompraActivity.class);
        intent.putExtra("id_producto", String.valueOf(producto.getId().getField()));
        intent.putExtra("nombre_producto", producto.getNombre());
        intent.putExtra("precio_producto", String.valueOf(producto.getPrecio()));

        context.startActivity(intent);

    }

}

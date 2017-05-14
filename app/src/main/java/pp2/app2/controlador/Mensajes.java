package pp2.app2.controlador;

import android.content.Context;
import android.widget.Toast;

import pp2.app2.modelo.app.Constantes;

/**
 * Created by jalvarez on 10/05/2017.
 */

public class Mensajes
{
    //Mostrar cartelitos de error
    protected static void informarErrorDeConexion(Context context)
    {
        Toast.makeText(context, Constantes.msg_no_conexion, Toast.LENGTH_SHORT).show();
    }

    protected static void informarErrorGeneral(Context context)
    {
        Toast.makeText(context, Constantes.msg_error_general, Toast.LENGTH_SHORT).show();
    }

    protected static void informarFuncionalidadNoDisponible(Context context)
    {
        Toast.makeText(context, Constantes.msg_funcionalidad_no_disponible, Toast.LENGTH_SHORT).show();
    }

    protected static void informarSinStock(Context context)
    {
        Toast.makeText(context, Constantes.msg_sin_stock, Toast.LENGTH_SHORT).show();
    }

}

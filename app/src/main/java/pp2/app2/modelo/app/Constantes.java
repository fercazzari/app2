package pp2.app2.modelo.app;

import java.util.Random;

import pp2.app2.modelo.app.DatosTemp;

/**
 * Created by Jony on 25/03/2017.
 */

public class Constantes {
    public final static String nombre_app = "Super En Casa";
    public final static String msg_no_conexion = "No hay conexión.";
    public final static String msg_sincro_ok = "Se sincronizo.";
    public final static String msg_sincro_mal = "No se sincronizo.";

    public final static String msg_sin_stock = "No hay stock del producto.";
    public final static String msg_error_general = "Error general.";
    public final static String msg_funcionalidad_no_disponible = "Funcionalidad no disponible.";

    public static final DatosTemp dbTemp = new DatosTemp();

    public static boolean getRespuestaDeSincronizacion() {
        // desde el web service
        Random random = new Random();
        return random.nextBoolean();
    }
}

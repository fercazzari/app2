package pp2.app2.helpers;

import java.util.Random;

import pp2.app2.modelo.DatosTemp;

/**
 * Created by Jony on 25/03/2017.
 */

public class Constantes {
    public final static String nombre_app = "Super En Casa";
    public final static String msg_no_conexion = "No hay conexión.";
    public final static String msg_sincro_ok = "Se sincronizo.";
    public final static String msg_sincro_mal = "No se sincronizo.";

    public static final DatosTemp dbTemp = new DatosTemp();

    public static boolean getRespuestaDeSincronizacion() {
        // desde el web service
        Random random = new Random();
        return random.nextBoolean();
    }
}

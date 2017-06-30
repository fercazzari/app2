package pp2.app2.modelo.app;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import pp2.app2.modelo.domain.CarritoUOW;

/**
 * Created by Jony on 23/04/2017.
 */

public class Conexion {
    //Todo lo que haga falta para una conexion

    public static boolean sincronizar(CarritoUOW uow)
    {
        return Constantes.getRespuestaDeSincronizacion();
    }

    public static boolean hayConexion() {
        return true;
    }
    /* public static boolean hayConexion(ConnectivityManager cm) {
        ConnectivityManager connectivityManager = cm;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    } */
}

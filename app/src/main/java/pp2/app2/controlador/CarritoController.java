package pp2.app2.controlador;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

import pp2.app2.modelo.Carrito;
import pp2.app2.vista.activities.CarritoActivity;

/**
 * Created by fcazzari on 09/04/2017.
 */

public class CarritoController implements ApplicationController {

    private Carrito carrito;
    private CarritoActivity carritoActivity;

    public CarritoController (Carrito carrito, CarritoActivity carritoActivity) {
        this.carrito = carrito;
        this.carritoActivity = carritoActivity;
    }

}

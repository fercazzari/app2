package pp2.app2.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pp2.app2.helpers.Conexion;
import pp2.app2.helpers.Constantes;
import pp2.app2.modelo.Carrito;

public class UnicaActivity extends AppCompatActivity {

    /*
     * Caso Random.
     * El carrito tiene 3 productos.
     * Si hay conexión, se "manda" el unit of work.
     * La app "recibe" confirmación.
     * Si la sincro salió OK, mensaje OK. Sino, error.
     */

    /* Caso 1.
     * El carrito está vacío.
     * Hay conexión.
     * Igual se intenta la sincronización.
     */

    /* Caso 2.
     * El carrito tiene 2 productos.
     * Hay conexión.
     * La sincronización se realiza correctamente.
     */

    /* Caso 3.
     * El carrito tiene 2 productos.
     * Hay conexión.
     * No se sincroniza correctamente porque no se recibió la confirmación del ws.
     */

    /* Caso 4.
     * El carrito tiene 2 productos.
     * No hay conexión.
     * No se sincroniza correctamente.
     */

    public void sincronizar(View view, Carrito carrito, Button btn) {

        if (Conexion.hayConexion((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE))) {

            if (carrito.hayQueSincronizar())
            {
                if (Conexion.sincronizar(carrito.getUOW()))
                {
                    carrito.sincronizado();
                    Toast.makeText(getApplicationContext(), Constantes.msg_sincro_ok, Toast.LENGTH_SHORT).show();
                    carrito.getUOW().clear();
                    btn.setEnabled(false);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), Constantes.msg_sincro_mal, Toast.LENGTH_SHORT).show();
                    btn.setEnabled(true);
                }
            }

        } else {
            Toast.makeText(getApplicationContext(), Constantes.msg_no_conexion, Toast.LENGTH_SHORT).show();
        }
    }

}

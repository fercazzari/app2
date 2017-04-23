package pp2.app2.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import pp2.app2.R;
import pp2.app2.helpers.Conexion;
import pp2.app2.helpers.Constantes;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Producto;

public class UnicaActivity extends AppCompatActivity {

    private Carrito carrito, carrito1, carrito2, carrito3, carrito4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        /*
         * Caso Random.
         * El carrito tiene 3 productos.
         * Si hay conexión, se "manda" el unit of work.
         * La app "recibe" confirmación.
         * Si la sincro salió OK, mensaje OK. Sino, error.
         */

        carrito = new Carrito();
        carrito.agregarItem(new Producto(1, "anana", 2));
        carrito.agregarItem(new Producto(2, "manzana", 2));
        carrito.agregarItem(new Producto(3, "kiwi", 2));

        setContentView(R.layout.activity_test);
        final Button button = (Button) findViewById(R.id.btn_sincronizar);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sincronizar(v, carrito, button);
            }
        });

        /* Caso 1.
         * El carrito está vacío.
         * Hay conexión.
         * Igual se intenta la sincronización.
         */

        carrito1 = new Carrito();

        final Button btn_sincro1 = (Button) findViewById(R.id.btn_sincro1);
        btn_sincro1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sincronizar(v, carrito1, btn_sincro1);
            }
        });

        /* Caso 2.
         * El carrito tiene 2 productos.
         * Hay conexión.
         * La sincronización se realiza correctamente.
         */

        carrito2 = new Carrito();
        carrito2.agregarItem(new Producto(2, "manzana", 2));
        carrito2.agregarItem(new Producto(3, "kiwi", 2));

        final Button btn_sincro2 = (Button) findViewById(R.id.btn_sincro2);
            btn_sincro2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sincronizar_caso2(v, carrito2, btn_sincro2);
            }
        });

        /* Caso 3.
         * El carrito tiene 2 productos.
         * Hay conexión.
         * No se sincroniza correctamente porque no se recibió la confirmación del ws.
         */

        carrito3 = new Carrito();
        carrito2.agregarItem(new Producto(2, "manzana", 2));
        carrito2.agregarItem(new Producto(3, "kiwi", 2));


        final Button btn_sincro3 = (Button) findViewById(R.id.btn_sincro3);
            btn_sincro3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sincronizar_caso3(v, carrito3, btn_sincro3);
            }
        });

        /* Caso 4.
         * El carrito tiene 2 productos.
         * No hay conexión.
         * No se sincroniza correctamente.
         */

        carrito4 = new Carrito();
        carrito4.agregarItem(new Producto(2, "manzana", 2));
        carrito4.agregarItem(new Producto(3, "kiwi", 2));

        final Button btn_sincro4 = (Button) findViewById(R.id.btn_sincro4);
            btn_sincro4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sincronizar_caso4(v, carrito4, btn_sincro4);
            }
        });


    }

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
            /*
            boolean sincroMock = getConfirmacion();

            if (sincroMock) {
                Toast.makeText(getApplicationContext(), Constantes.msg_sincro_ok, Toast.LENGTH_SHORT).show();
                carrito.getUOW().clear();
                btn.setEnabled(false);
                return true;
            } else {
                Toast.makeText(getApplicationContext(), Constantes.msg_sincro_mal, Toast.LENGTH_SHORT).show();
                btn.setEnabled(true);
                return false;
            }
            */

        } else {
            Toast.makeText(getApplicationContext(), Constantes.msg_no_conexion, Toast.LENGTH_SHORT).show();
        }
    }

    public void sincronizar_caso2(View view, Carrito carrito, Button btn) {

        if (Conexion.hayConexion((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE))) {

            // mandarCarritoUOW(carrito);
            boolean sincroMock = true;

            if (sincroMock) {
                Toast.makeText(getApplicationContext(), Constantes.msg_sincro_ok, Toast.LENGTH_SHORT).show();
                carrito.getUOW().clear();
                btn.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), Constantes.msg_sincro_mal, Toast.LENGTH_SHORT).show();
                btn.setEnabled(true);
            }

        } else {

            Toast.makeText(getApplicationContext(), Constantes.msg_no_conexion, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean sincronizar_caso3(View view, Carrito carrito, Button btn) {

        if (Conexion.hayConexion((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE))) {

            // mandarCarritoUOW(carrito);
            boolean sincroMock = false;

            if (sincroMock) {
                Toast.makeText(getApplicationContext(), Constantes.msg_sincro_ok, Toast.LENGTH_SHORT).show();
                carrito.getUOW().clear();
                btn.setEnabled(false);
                return true;
            } else {
                Toast.makeText(getApplicationContext(), Constantes.msg_sincro_mal, Toast.LENGTH_SHORT).show();
                btn.setEnabled(true);
                return false;
            }

        } else {

            Toast.makeText(getApplicationContext(), Constantes.msg_no_conexion, Toast.LENGTH_SHORT).show();
            return false;

        }
    }

    public boolean sincronizar_caso4(View view, Carrito carrito, Button btn) {

        boolean hayConexion = false;
        if (hayConexion) {

            // mandarCarritoUOW(carrito);
            boolean sincroMock = getConfirmacion();

            if (sincroMock) {
                Toast.makeText(getApplicationContext(), Constantes.msg_sincro_ok, Toast.LENGTH_SHORT).show();
                carrito.getUOW().clear();
                btn.setEnabled(false);
                return true;
            } else {
                Toast.makeText(getApplicationContext(), Constantes.msg_sincro_mal, Toast.LENGTH_SHORT).show();
                btn.setEnabled(true);
                return false;
            }

        } else {

            Toast.makeText(getApplicationContext(), Constantes.msg_no_conexion, Toast.LENGTH_SHORT).show();
            return false;

        }
    }

    public void mandarCarritoUOW(Carrito carrito) {
        Gson gson = new Gson();
        gson.toJson(carrito.getUOW());

        String url = "http://localhost:8080/superencasa/rest/carrito/test";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(UnicaActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UnicaActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("test","hello");
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public boolean getConfirmacion() {
        // desde el web service
        Random random = new Random();
        return random.nextBoolean();
    }
}

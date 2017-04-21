package pp2.app2.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import pp2.app2.helpers.Constantes;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Producto;

public class UnicaActivity extends AppCompatActivity {

    Carrito carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        carrito = new Carrito();
        carrito.agregarItem(new Producto(1, "anana", 2));
        carrito.agregarItem(new Producto(2, "manzana", 2));
        carrito.agregarItem(new Producto(3, "kiwi", 2));
        carrito.eliminarItem(new Producto(2, "manzana", 2));

        setContentView(R.layout.activity_test);
        final Button button = (Button) findViewById(R.id.btn_sincronizar);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sincronizar(v, carrito, button);
            }
        });
    }

    public boolean sincronizar(View view, Carrito carrito, Button btn) {

        if (hayConexion()) {

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

    private boolean hayConexion() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}

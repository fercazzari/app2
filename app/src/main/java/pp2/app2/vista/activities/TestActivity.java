package pp2.app2.vista.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Random;

import pp2.app2.R;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Producto;

public class TestActivity extends AppCompatActivity {

    String url = "http://localhost:8080/superencasa/rest/carrito/test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Carrito carrito = new Carrito();
        carrito.agregarItem(new Producto(1, "anana", 2));
        carrito.agregarItem(new Producto(2, "manzana", 2));
        carrito.agregarItem(new Producto(3, "kiwi", 2));
        carrito.eliminarItem(new Producto(2, "manzana", 2));

        // mando las tres listas al sincro
        // si todo ok, las limpio

        Random random = new Random();
        boolean sincronizo = random.nextBoolean();

        // TODO ? :
        if (sincronizo) {
            Toast.makeText(getApplicationContext(),
                    "Se sincronizo",
                    Toast.LENGTH_SHORT).show();
            carrito.getUOW().clear();
        } else {
            Toast.makeText(getApplicationContext(),
                    "No se sincronizó.",
                    Toast.LENGTH_SHORT).show();
        }

        /*

        Producto prod1 = new Producto(1, "anana", 1);
        Producto prod2 = new Producto(2, "manzana", 1);

        Carrito carrito = new Carrito();
        carrito.agregarItem(prod1);
        carrito.agregarItem(prod2);

        // armo el json para mandarselo al web service

        try {

            JSONObject obj1 = new JSONObject();

            obj1.put("id", prod1.getId());
            obj1.put("nombre", prod1.getNombre());
            obj1.put("idCategoria", prod1.getIdCategoria());

            JSONObject obj2 = new JSONObject();

            obj2.put("id", prod2.getId());
            obj2.put("nombre", prod2.getNombre());
            obj2.put("idCategoria", prod2.getIdCategoria());

            JSONArray jsonArray = new JSONArray();

            jsonArray.put(obj1);
            jsonArray.put(obj2);

            JSONObject carritoJson = new JSONObject();
            carritoJson.put("carrito", jsonArray);

            json = carritoJson.toString();

            TextView tv = (TextView)findViewById(R.id.test);

        } catch (JSONException e) {
            // TODO
        }
        tv = (TextView)findViewById(R.id.test);
        try {
            RequestQueue queue = Volley.newRequestQueue(this);
            jsonBody = new JSONObject();

            jsonBody.put("Test", "{\"hello\":\"world\"}");

            requestBody = jsonBody.toString();
            tv.setText(requestBody);

            StringRequest stringRequest = new StringRequest(1, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    tv.setText(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    tv.setText(error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return String.format("application/json; charset=utf-8");
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
                                requestBody, "utf-8");
                        return null;
                    }
                }
            };

            queue.add(stringRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }

*/
    }
}

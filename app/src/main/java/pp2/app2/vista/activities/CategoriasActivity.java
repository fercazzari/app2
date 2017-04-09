package pp2.app2.vista.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pp2.app2.R;
import pp2.app2.modelo.Categoria;

public class CategoriasActivity extends AppCompatActivity {

    ListView lv_categorias;
    List<Categoria> categorias;
    String url = "https://api.myjson.com/bins/guk23";
    // String url = "http://192.168.1.16:8080/superencasa/rest/catalogo/obtenerMenuPrincipal";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        lv_categorias = (ListView)findViewById(R.id.categorias);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Cargando...");
        dialog.show();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonDataCategorias(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Todo mal...", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(CategoriasActivity.this);
        rQueue.add(request);
    }

    void parseJsonDataCategorias(String jsonString) {

        this.categorias = new LinkedList<Categoria>();

        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray jarr = object.getJSONArray("categorias");

            for (int i = 0; i < jarr.length(); i++) {

                JSONObject o = jarr.getJSONObject(i);
                this.categorias.add(new Categoria(Integer.valueOf(o.getString("idCategoria")), o.getString("nombre")));

            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.categorias);
            lv_categorias.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }
}

package pp2.app2.vista.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
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
    // String url = "http://localhost:8080/superencasa/rest/catalogo/obtenerMenuPrincipal";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        lv_categorias = (ListView) findViewById(R.id.categorias);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Cargando...");
        dialog.show();

        // TODO cambiar categorias:
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonDataCategorias(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "No se encontraron categorías.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(CategoriasActivity.this);
        rQueue.add(request);

        // item elegido
        lv_categorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Categoria elegida = (Categoria) lv_categorias.getItemAtPosition(i);

                // para pasarle la categoria elegida al catalogo
                Intent intent = new Intent(getApplicationContext(), CatalogoActivity.class);
                intent.putExtra("id_categoria", String.valueOf(elegida.getId()));
                // Toast.makeText(getApplicationContext(), String.valueOf(elegida.getId()), Toast.LENGTH_SHORT).show();
                // TODO intent.putExtra("nombre", elegida.getNombre());
                startActivity(intent);

            }
        });
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

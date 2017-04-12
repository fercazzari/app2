package pp2.app2.vista.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

import java.util.LinkedList;
import java.util.List;

import pp2.app2.R;
import pp2.app2.modelo.Categoria;
import pp2.app2.modelo.Producto;

public class CatalogoActivity extends AppCompatActivity {

    ListView lv_productos;
    List<Producto> productos;
    String url = "https://api.myjson.com/bins/1behcv";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        lv_productos = (ListView) findViewById(R.id.catalogo);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Cargando...");
        dialog.show();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonDataProductos(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "No se encontraron productos.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(CatalogoActivity.this);
        rQueue.add(request);

        // elijo un  producto para ver los detalles y agregarlo al carrito

        lv_productos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Producto elegido = (Producto) lv_productos.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(), ProductoActivity.class);
                intent.putExtra("id_producto", String.valueOf(elegido.getId()));
                intent.putExtra("nombre_producto", elegido.getNombre());
                intent.putExtra("categoria_producto", String.valueOf(elegido.getIdCategoria()));
                // Toast.makeText(getApplicationContext(), String.valueOf(elegida.getId()), Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

    }

    void parseJsonDataProductos (String jsonString) {

        this.productos = new LinkedList<Producto>();

        // TODO armar objeto Categoria con la data del intent
        String id_categoria = getIntent().getStringExtra("id_categoria");

        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray jarr = object.getJSONArray("productos");

            for (int i = 0; i < jarr.length(); i++) {

                JSONObject o = jarr.getJSONObject(i);

                if (id_categoria.equals(o.getString("categoria"))) {

                    this.productos.add(
                            new Producto(Integer.valueOf(o.getString("id")),
                                    o.getString("nombre"),
                                    Integer.valueOf(o.getString("categoria")))
                    );
                }
            }

            if (this.productos.isEmpty()) {
                Toast.makeText(getApplicationContext(), "No se encontraron productos de la categoria " + id_categoria, Toast.LENGTH_SHORT).show();
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.productos);
            lv_productos.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }

}

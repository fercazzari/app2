package pp2.app2.vista;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pp2.app2.R;
import pp2.app2.helpers.ApiConnector;

public class CatalogoActivityOLD extends Activity {

    // private List<Producto> productos;
    // private AppController catalogoController;

    private String TAG = CatalogoActivityOLD.class.getSimpleName();
    private ListView lv;
    private ProgressDialog progressDialog;
    private static String url = "https://api.myjson.com/bins/1gz3i3";
    // private static String url = "http://localhost:8080/superencasa/rest/catalogo/obtenerCategorias";
    private List<Map<String, String>> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityold_catalogo);

        /* this.catalogoController = new AppController();
        this.productos = catalogoController.getCatalogo(getResources());

        lv = (ListView) findViewById(R.id.ListViewCatalogo);
        lv.setAdapter(new ProductoAdapter(productos, getLayoutInflater()));

        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Producto producto = (Producto) lv.getItemAtPosition(position);

                // para pasar data entre activities
                Intent intent = new Intent(CatalogoActivityOLD.this, ProductoActivity.class);
                Bundle b = new Bundle();
                b.putInt("id", producto.getId());
                intent.putExtras(b);
                startActivity(intent);
                finish();

            }
        }); */

        productos = new LinkedList<>();
        lv = (ListView) findViewById(R.id.ListViewCatalogo);

        new GetProductos().execute();

    }

    private class GetProductos extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(CatalogoActivityOLD.this);
            progressDialog.setMessage("Estamos armando el catálogo...");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }
        @Override
        protected Void doInBackground(Void... arg0) {

            ApiConnector apiConnector = new ApiConnector();
            String json = apiConnector.callService(url);

            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);

                    JSONArray contacts = jsonObj.getJSONArray("productos");

                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString("id");
                        String nombre = c.getString("nombre");
                        String descripcion = c.getString("descripcion");

                        // TODO map -> Producto + constructor
                        Map<String, String> producto = new HashMap<>();

                        producto.put("id", id);
                        producto.put("nombre", nombre);
                        producto.put("descripcion", descripcion);

                        productos.add(producto);
                    }
                } catch (final JSONException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Error en el parseo del json: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "No pudimos obtener los datos.",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;

        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (progressDialog.isShowing())
                progressDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    CatalogoActivityOLD.this, productos,
                    R.layout.item, new String[]{"nombre", "descripcion"},
                    new int[]{R.id.nombre,
                    R.id.descripcion});

            lv.setAdapter(adapter);
        }

    }

}

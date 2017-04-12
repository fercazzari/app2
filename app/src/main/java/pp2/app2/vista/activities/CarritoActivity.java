package pp2.app2.vista.activities;

import android.app.ProgressDialog;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.toolbox.JsonObjectRequest;

import java.util.List;

import pp2.app2.R;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Categoria;
import pp2.app2.modelo.Producto;

public class CarritoActivity extends AppCompatActivity {

    Carrito carrito;
    ListView lv_productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        String id_producto = getIntent().getStringExtra("id_producto");
        String nombre_producto = getIntent().getStringExtra("nombre_producto");
        String categoria_producto = getIntent().getStringExtra("categoria_producto");

        Producto producto = new Producto(Integer.valueOf(id_producto), nombre_producto, Integer.valueOf(categoria_producto));

        this.carrito = new Carrito();
        this.carrito.agregarItem(producto);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.carrito.getItems());
        lv_productos.setAdapter(adapter);

    }
}

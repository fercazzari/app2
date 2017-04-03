package pp2.app2.vista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import pp2.app2.R;
import pp2.app2.adapter.ProductoAdapter;
import pp2.app2.controlador.CatalogoController;
import pp2.app2.modelo.Producto;

public class CatalogoActivity extends Activity {

    private List<Producto> productos;
    private CatalogoController catalogoController;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        this.catalogoController = new CatalogoController();
        this.productos = catalogoController.getCatalogo(getResources());

        lv = (ListView) findViewById(R.id.ListViewCatalogo);
        lv.setAdapter(new ProductoAdapter(productos, getLayoutInflater()));

        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Producto producto = (Producto) lv.getItemAtPosition(position);

                // para pasar data entre activities
                Intent intent = new Intent(CatalogoActivity.this, ProductoActivity.class);
                Bundle b = new Bundle();
                b.putInt("id", producto.getId());
                intent.putExtras(b);
                startActivity(intent);
                finish();

            }
        });

    }

}

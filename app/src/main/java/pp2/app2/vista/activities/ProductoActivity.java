package pp2.app2.vista.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pp2.app2.R;
import pp2.app2.controlador.AppController;
import pp2.app2.modelo.Producto;

public class ProductoActivity extends AppCompatActivity {

    private AppController catalogoController;
    private Producto actual;
    private int producto_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        /* para recibir data de activities
        Bundle b = getIntent().getExtras();
        producto_id = -1;
        if(b != null)
            producto_id = b.getInt("id");

        // busco en el catalogo por id
        catalogoController = new AppController();
        List<Producto> productos = catalogoController.getCatalogo(getResources());
        this.actual = catalogoController.getProducto(productos, producto_id);

        FloatingActionButton fab_agregar = (FloatingActionButton) findViewById(R.id.fab_agregar);
        fab_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),
                        "Se agregó el producto " + producto_id + " al carrito (mentira)",
                        Toast.LENGTH_SHORT).show();

            }
        }); */

    }
}

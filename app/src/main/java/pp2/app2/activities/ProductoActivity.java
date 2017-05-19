package pp2.app2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pp2.app2.R;
import pp2.app2.controlador.CompraController;
import pp2.app2.modelo.app.DatosTemp;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;

public class ProductoActivity extends AppCompatActivity {

    private Producto producto;
    private DatosTemp datosTemp;
    private SolicitudDeCompra solicitud;

    private TextView producto_nombre;
    private Button btn_agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        init();
        recibirIntent();
        armarPantalla();
        handleEventos();

    }

    public void init() {

        this.datosTemp = new DatosTemp();
        this.producto = datosTemp.obtenerProducto(102);
        this.solicitud = new SolicitudDeCompra();
        this.producto = new Producto(producto.getId(), producto.getNombre(), producto.getPrecio());

    }

    public void recibirIntent () {

        String sc_mensaje_error = getIntent().getStringExtra("sc_mensaje_error");
        if(sc_mensaje_error != null)
        {
            Toast.makeText(this, sc_mensaje_error, Toast.LENGTH_SHORT).show();
        }

    }

    public void armarPantalla () {

        this.producto_nombre = (TextView)findViewById(R.id.producto_nombre);
        producto_nombre.setText(producto.getNombre());

    }

    public void handleEventos () {
        btn_agregar = (Button) findViewById(R.id.button_agregar);
        btn_agregar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CompraController.agregarProducto(getApplicationContext(), solicitud, producto);
            }
        });
    }
}

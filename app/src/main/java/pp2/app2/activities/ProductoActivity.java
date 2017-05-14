package pp2.app2.activities;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pp2.app2.R;
import pp2.app2.controlador.ApplicationController;
import pp2.app2.modelo.app.DatosTemp;
import pp2.app2.modelo.domain.Producto;

public class ProductoActivity extends AppCompatActivity {

    private Producto producto;
    private DatosTemp datosTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        this.datosTemp = new DatosTemp();
        this.producto = datosTemp.obtenerProducto(102);

        this.producto = new Producto(producto.getId(), producto.getNombre(), producto.getPrecio());

        final TextView producto_nombre = (TextView)findViewById(R.id.producto_nombre);
        producto_nombre.setText(producto.getNombre());

        Button btn_agregar = (Button) findViewById(R.id.button_agregar);
        btn_agregar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ApplicationController.agregarProducto(getApplicationContext(), producto);
            }
        });

    }
}

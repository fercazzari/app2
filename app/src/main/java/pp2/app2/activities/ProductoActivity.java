package pp2.app2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import pp2.app2.R;
import pp2.app2.modelo.DatosTemp;
import pp2.app2.modelo.Producto;

public class ProductoActivity extends AppCompatActivity {

    private Producto actual;
    private DatosTemp datosTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        this.datosTemp = new DatosTemp();
        this.actual = datosTemp.obtenerProducto(102);

        this.actual = new Producto(actual.getId(), actual.getNombre());

        TextView producto_nombre = (TextView)findViewById(R.id.producto_nombre);
        producto_nombre.setText(actual.getNombre());

    }
}

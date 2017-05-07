package pp2.app2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        this.actual = new Producto(actual.getId(), actual.getNombre(), actual.getPrecio());

        TextView producto_nombre = (TextView)findViewById(R.id.producto_nombre);
        producto_nombre.setText(actual.getNombre());

        Button button_comprar = (Button) findViewById(R.id.button_comprar);
        button_comprar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // el onClick sería agregar al carrito. Por ahora va a ser comprar!
                Intent intent = new Intent(getApplicationContext(), CompraActivity.class);
                intent.putExtra("id_producto", String.valueOf(actual.getId().getField()));
                intent.putExtra("nombre_producto", actual.getNombre());
                intent.putExtra("precio_producto", String.valueOf(actual.getPrecio()));

                startActivity(intent);
                
            }
        });

    }
}

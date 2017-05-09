package pp2.app2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pp2.app2.R;
import pp2.app2.helpers.IdentityField;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Producto;

public class CompraActivity extends AppCompatActivity {

    private Carrito carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        // todos los details del producto para agregarlo al carrito
        String id_producto = getIntent().getStringExtra("id_producto");
        String nombre_producto = getIntent().getStringExtra("nombre_producto");
        String precio_producto = getIntent().getStringExtra("precio_producto");

        this.carrito = new Carrito();
        this.carrito.agregarItem(
                new Producto(new IdentityField(Integer.valueOf(id_producto)), nombre_producto, Double.valueOf(precio_producto)));

        TextView tv_cantidad = (TextView)findViewById(R.id.txt_cantidad);
        tv_cantidad.setText(String.valueOf(this.carrito.getCantidad()));

        TextView tv_total = (TextView)findViewById(R.id.txt_total);
        tv_total.setText(String.valueOf(this.carrito.getTotal()));

        Button button_finalizar = (Button)findViewById(R.id.button_finalizar);
        button_finalizar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO sincronizar el carrito con el ws
                Toast.makeText(CompraActivity.this, "Compra finalizada. Retirá el producto por el local!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

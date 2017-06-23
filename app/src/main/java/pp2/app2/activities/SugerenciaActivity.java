package pp2.app2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pp2.app2.R;
import pp2.app2.modelo.app.DatosTemp;
import pp2.app2.modelo.domain.Producto;

public class SugerenciaActivity extends AppCompatActivity {

    private Producto producto, recomendado;
    private String id_producto, nombre_producto, precio_producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencia);

        init();
        recibirIntent();
        rearmarProducto();
        armarPantalla();
        handleEventos();

    }

    public void init() {
        DatosTemp datosTemp = new DatosTemp();
        recomendado = new Producto();
        recomendado = datosTemp.obtenerProducto(107);
    }

    public void recibirIntent() {
        // armo el producto que viene de la activity anterior
        id_producto = getIntent().getStringExtra("id_producto");
        nombre_producto = getIntent().getStringExtra("nombre_producto");
        precio_producto = getIntent().getStringExtra("precio_producto");
    }

    public void rearmarProducto() {
        producto = new Producto(Integer.valueOf(id_producto), nombre_producto, Double.valueOf(precio_producto));
    }

    public void armarPantalla() {

        TextView lbl_compra = (TextView)findViewById(R.id.lbl_compra);
        lbl_compra.setText("Como compraste: ");

        TextView txt_producto = (TextView)findViewById(R.id.txt_producto);
        txt_producto.setText(producto.getNombre());

        TextView lbl_sugerencia = (TextView)findViewById(R.id.lbl_sugerencia);
        lbl_sugerencia.setText("Te sugerimos también comprar:");

        TextView tv_recomendado = (TextView)findViewById(R.id.txt_recomendado);
        tv_recomendado.setText(recomendado.getNombre());

    }

    public void handleEventos() {

        Button button_omitir = (Button)findViewById(R.id.button_omitir);
        button_omitir.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        Button button_agregar = (Button)findViewById(R.id.button_agregar);
        button_agregar.setEnabled(false);
        button_agregar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // CompraController.hacerAlgo()
            }
        });

    }


}

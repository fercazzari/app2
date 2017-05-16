package pp2.app2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import pp2.app2.R;
import pp2.app2.controlador.ApplicationController;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.IdentityField;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;

public class PagoActivity extends AppCompatActivity {

    private SolicitudDeCompra solicitud;
    private Producto producto;
    private Domicilio domicilio;
    private MedioDePago medioDePago;
    private RadioGroup radioPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        this.solicitud = new SolicitudDeCompra();

        String sc_producto_id = getIntent().getStringExtra("sc_producto_id");
        String sc_producto_nombre = getIntent().getStringExtra("sc_producto_nombre");
        String sc_producto_precio = getIntent().getStringExtra("sc_producto_precio");

        this.producto = new Producto(new IdentityField(Integer.valueOf(sc_producto_id)), sc_producto_nombre, Double.valueOf(sc_producto_precio));
        this.solicitud.agregarProducto(producto);

        String sc_domicilio = getIntent().getStringExtra("sc_domicilio");
        
        this.domicilio = new Domicilio(sc_domicilio);
        this.solicitud.setDomicilioEntrega(domicilio);

        /* radioPago = (RadioGroup)findViewById(R.id.radioPago);
        radioPago.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                medioDePago = new MedioDePago("Tarjeta");
                if (checkedId == R.id.rb_tarjeta){
                    medioDePago = new MedioDePago("Tarjeta");
                    // Toast.makeText(PagoActivity.this, medioDePago.toString(), Toast.LENGTH_SHORT).show();
                }else if (checkedId == R.id.rb_mercadoPago) {
                    medioDePago = new MedioDePago("MercadoPago");
                    // Toast.makeText(PagoActivity.this, medioDePago.toString(), Toast.LENGTH_SHORT).show();
                }


            }

        }); */

        Button btn_p1 = (Button)findViewById(R.id.btn_p1);
        btn_p1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                medioDePago = new MedioDePago("Tarjeta");
                // Toast.makeText(PagoActivity.this, solicitud.getMedioDePago().getTipo(), Toast.LENGTH_SHORT).show();
            }

        });

        Button btn_p2 = (Button)findViewById(R.id.btn_p2);
        btn_p2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }

        });

        Button btn_pagar = (Button)findViewById(R.id.btn_pagar);
        btn_pagar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ApplicationController.confirmarMedioDePago(getApplicationContext(), solicitud, medioDePago);
            }

        });

    }

}

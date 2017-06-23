package pp2.app2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import pp2.app2.R;
import pp2.app2.controlador.CompraController;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.MercadoPago;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;
import pp2.app2.modelo.domain.Tarjeta;

public class PagoActivity extends AppCompatActivity {

    private SolicitudDeCompra solicitud;
    private Producto producto;
    private Domicilio domicilio;
    private MedioDePago medioDePago;
    private RadioGroup radioPago;
    private String sc_producto_id, sc_producto_nombre, sc_producto_precio, sc_domicilio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        init();
        recibirIntent();
        rearmarSolicitud();
        handleEventos();

    }

    private void handleEventos() {

        // por si no marca ningún rb y pone siguiente
        medioDePago = new Tarjeta("XXXX-XXXX-XXXX-XXXX");

        radioPago = (RadioGroup)findViewById(R.id.radioPago);
        radioPago.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rb_tarjeta){
                    medioDePago = new Tarjeta("XXXX-XXXX-XXXX-XXXX");
                }else if (checkedId == R.id.rb_mercadoPago) {
                    medioDePago = new MercadoPago("Visa");
                }

            }

        });

        Button btn_pagar = (Button)findViewById(R.id.btn_pagar);
        btn_pagar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CompraController.confirmarMedioDePago(getApplicationContext(), solicitud, medioDePago);
            }

        });

    }

    private void rearmarSolicitud() {
        this.producto = new Producto(Integer.valueOf(sc_producto_id), sc_producto_nombre, Double.valueOf(sc_producto_precio));
        this.solicitud.agregarProducto(producto);

        this.domicilio = new Domicilio(sc_domicilio);
        this.solicitud.setDomicilioEntrega(domicilio);
    }

    private void recibirIntent() {
        sc_producto_id = getIntent().getStringExtra("sc_producto_id");
        sc_producto_nombre = getIntent().getStringExtra("sc_producto_nombre");
        sc_producto_precio = getIntent().getStringExtra("sc_producto_precio");
        sc_domicilio = getIntent().getStringExtra("sc_domicilio");
    }

    private void init() {
        this.solicitud = new SolicitudDeCompra();
    }

}

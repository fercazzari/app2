package pp2.app2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pp2.app2.R;
import pp2.app2.controlador.ApplicationController;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.IdentityField;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;

public class DomicilioActivity extends AppCompatActivity {

    SolicitudDeCompra solicitudDeCompra;
    Domicilio domicilio;
    Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domicilio);

        String sc_producto_id = getIntent().getStringExtra("sc_producto_id");
        String sc_producto_nombre = getIntent().getStringExtra("sc_producto_nombre");
        String sc_producto_precio = getIntent().getStringExtra("sc_producto_precio");

        this.solicitudDeCompra = new SolicitudDeCompra();
        this.producto = new Producto(new IdentityField(Integer.valueOf(sc_producto_id)), sc_producto_nombre, Double.valueOf(sc_producto_precio));
        this.solicitudDeCompra.agregarProducto(producto);

        TextView lbl_domicilio = (TextView)findViewById(R.id.lbl_domicilio);
        lbl_domicilio.setText("El domicilio de entrega es: ");

        domicilio = new Domicilio(getIntent().getStringExtra("sc_domicilio"));

        TextView txt_domicilio = (TextView)findViewById(R.id.txt_domicilio);
        txt_domicilio.setText(domicilio.getDatos());

        Button btn_cambiar_domicilio = (Button)findViewById(R.id.btn_cambiar_domicilio);
        btn_cambiar_domicilio.setEnabled(false);
        btn_cambiar_domicilio.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO
            }

        });

        Button btn_domicilio_ok = (Button)findViewById(R.id.btn_domicilio_ok);
        btn_domicilio_ok.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ApplicationController.confirmarDomicilio(getApplicationContext(), solicitudDeCompra, domicilio);
            }

        });



    }
}

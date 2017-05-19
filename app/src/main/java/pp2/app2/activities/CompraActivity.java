package pp2.app2.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pp2.app2.R;
import pp2.app2.controlador.CompraController;
import pp2.app2.modelo.app.Conexion;
import pp2.app2.modelo.app.Constantes;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.IdentityField;
import pp2.app2.modelo.domain.Carrito;
import pp2.app2.modelo.domain.Item;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.MercadoPago;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;
import pp2.app2.modelo.domain.Tarjeta;

public class CompraActivity extends AppCompatActivity {

    private SolicitudDeCompra solicitud;
    private Carrito carrito;
    private Producto producto;
    private MedioDePago medioDePago;
    private String id_producto, nombre_producto, precio_producto, sc_domicilio, sc_pago; // intent que viene

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        init();
        recibirIntent();
        rearmarSolicitud();
        llenarCarrito();
        armarPantalla();
        handleEventos();

    }

    public void init() {
        this.solicitud = new SolicitudDeCompra();
        this.carrito = new Carrito();
    }

    public void recibirIntent() {
        // todos los details de la solicitud para agregarlo al carrito
        id_producto = getIntent().getStringExtra("id_producto");
        nombre_producto = getIntent().getStringExtra("nombre_producto");
        precio_producto = getIntent().getStringExtra("precio_producto");

        sc_domicilio = getIntent().getStringExtra("sc_domicilio");
        sc_pago = getIntent().getStringExtra("sc_pago");
    }

    public void rearmarSolicitud() {

        producto = new Producto
                (new IdentityField(Integer.valueOf(id_producto)), nombre_producto, Double.valueOf(precio_producto));

        this.solicitud.agregarProducto(producto);
        this.solicitud.setDomicilioEntrega(new Domicilio(sc_domicilio));

        switch (sc_pago) {
            case "Tarjeta":
                medioDePago = new Tarjeta("XXXX-XXXX-XXXX-XXXX");
                break;
            case "MercadoPago":
                medioDePago = new MercadoPago("Visa");
                break;
        }

        this.solicitud.setMedioDePago(medioDePago);

    }

    public void llenarCarrito () {
        this.carrito = new Carrito();
        for (Item item : this.solicitud.getItems()) {
            this.carrito.agregarItem(item.getProducto());
        }
    }

    public void armarPantalla() {
        TextView tv_cantidad = (TextView)findViewById(R.id.txt_cantidad);
        tv_cantidad.setText(String.valueOf(this.carrito.getCantidad()));

        TextView tv_total = (TextView)findViewById(R.id.txt_total);
        tv_total.setText(String.valueOf(this.carrito.getTotal()));

        TextView tv_domicilio = (TextView)findViewById(R.id.txt_domicilio);
        tv_domicilio.setText(this.solicitud.getDomicilioEntrega().getDatos());

        TextView tv_pago = (TextView)findViewById(R.id.txt_pago);
        tv_pago.setText(this.solicitud.getMedioDePago().toString());
    }

    public void handleEventos() {

        Button button_finalizar = (Button)findViewById(R.id.button_finalizar);
        button_finalizar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CompraController.confirmarCompra(getApplicationContext(), solicitud);
            }
        });
    }

    public void sincronizar(View view, Carrito carrito, Button btn) {

        if (Conexion.hayConexion((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE))) {

            if (carrito.hayQueSincronizar())
            {
                if (Conexion.sincronizar(carrito.getUOW()))
                {
                    carrito.sincronizado();
                    Toast.makeText(getApplicationContext(), Constantes.msg_sincro_ok, Toast.LENGTH_SHORT).show();
                    carrito.getUOW().clear();
                    btn.setEnabled(false);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), Constantes.msg_sincro_mal, Toast.LENGTH_SHORT).show();
                    btn.setEnabled(true);
                }
            }

        } else {
            Toast.makeText(getApplicationContext(), Constantes.msg_no_conexion, Toast.LENGTH_SHORT).show();
        }
    }
}

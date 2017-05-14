package pp2.app2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import pp2.app2.R;
import pp2.app2.controlador.ApplicationController;
import pp2.app2.modelo.domain.Domicilio;

public class DomicilioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domicilio);

        TextView lbl_domicilio = (TextView)findViewById(R.id.lbl_domicilio);
        lbl_domicilio.setText("El domicilio de entrega es: ");

        final Domicilio domicilio = new Domicilio(getIntent().getStringExtra("domicilio"));
        TextView txt_domicilio = (TextView)findViewById(R.id.txt_domicilio);
        txt_domicilio.setText(domicilio.getDatos());

        Button btn_cambiar_domicilio = (Button)findViewById(R.id.btn_cambiar_domicilio);
        btn_cambiar_domicilio.setEnabled(false);
        btn_cambiar_domicilio.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        Button btn_domicilio_ok = (Button)findViewById(R.id.btn_domicilio_ok);
        btn_domicilio_ok.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ApplicationController.confirmarDomicilio(getApplicationContext(), domicilio);
            }
        });



    }
}

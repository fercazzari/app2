package pp2.app2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import pp2.app2.R;

public class PagoActivity extends AppCompatActivity {

    private RadioGroup radioPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        radioPago = (RadioGroup)findViewById(R.id.radioPago);
        radioPago.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rb_tarjeta){
                    Toast.makeText(PagoActivity.this, "Tarjeta", Toast.LENGTH_SHORT).show();
                }else if (checkedId == R.id.rb_mercadoPago) {
                    Toast.makeText(PagoActivity.this, "MercadoPago", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

}
